package com.lipe.questoes_br.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.lipe.questoes_br.Entity.Jogador;
import com.lipe.questoes_br.Entity.Partida;
import com.lipe.questoes_br.Entity.PartidaPergunta;
import com.lipe.questoes_br.Entity.Pergunta;
import com.lipe.questoes_br.Repository.JogadorRepository;
import com.lipe.questoes_br.Repository.PartidaPerguntaRepository;
import com.lipe.questoes_br.Repository.PartidaRepository;
import com.lipe.questoes_br.Repository.PerguntaRepository;
import com.lipe.questoes_br.dtos.DtoPartidaInicioResponse;
import com.lipe.questoes_br.dtos.DtoPartidaInput;
import com.lipe.questoes_br.dtos.DtoPartidaJogadaInput;
import com.lipe.questoes_br.dtos.DtoPartidaJogadaResponse;
import com.lipe.questoes_br.dtos.DtoPergunta;
import com.lipe.questoes_br.dtos.DtoVerificacaoResposta;

@Service
public class PartidaService {
    private final JogadorRepository jogadorRepository;
    private final PartidaRepository partidaRepository;
    private final PerguntaRepository perguntaRepository;
    private final PartidaPerguntaRepository partidaPerguntaRepository;
    private final PerguntaService perguntaService;

    public PartidaService(JogadorRepository jogadorRepository, PartidaRepository partidaRepository,
            PerguntaRepository perguntaRepository, PartidaPerguntaRepository partidaPerguntaRepository,
            PerguntaService perguntaService) {
        this.jogadorRepository = jogadorRepository;
        this.partidaRepository = partidaRepository;
        this.perguntaRepository = perguntaRepository;
        this.partidaPerguntaRepository = partidaPerguntaRepository;
        this.perguntaService = perguntaService;
    }

    public DtoPartidaInicioResponse iniciarPartida(DtoPartidaInput dtoInput) {
        // pesquisando ou criando jogador com base no apelido inserido//
        Jogador jogador = jogadorRepository.findByApelido(dtoInput.getApelido())
                .orElseGet(() -> {
                    Jogador novoJogador = new Jogador(dtoInput.getApelido());
                    return jogadorRepository.save(novoJogador);
                });

        // criando a partida//
        Partida novaPartida = new Partida(jogador);
        Partida partidaSalva = partidaRepository.save(novaPartida);

        // coletando perguntas com base na quantidade determinada//
        List<DtoPergunta> perguntasColetadas = perguntaService.coletarPerguntas(dtoInput.getQuantidadePerguntas());

        // coletando os ids das perguntas para pesquisar no banco//
        List<Long> idsPerguntas = perguntasColetadas.stream()
                .map(pergunta -> pergunta.getId())
                .collect(Collectors.toList());

        // pesquisando perguntas específicas pelo id no banco //
        List<Pergunta> perguntasJogo = perguntaRepository.findAllById(idsPerguntas);

        // convertendo a lista de entidades Pergunta para map para melhor desempenho //
        Map<Long, Pergunta> objectPerguntas = perguntasJogo.stream()
                .collect(Collectors.toMap(
                        pergunta -> pergunta.getId(),
                        pergunta -> pergunta));

        // criando associações entre a partida e as perguntas//
        List<PartidaPergunta> perguntasPartida = new ArrayList<>();
        perguntasColetadas.forEach(DtoPergunta -> {
            Pergunta perguntaEntidade = objectPerguntas.get(DtoPergunta.getId());
            PartidaPergunta associacao = new PartidaPergunta(partidaSalva, perguntaEntidade, false);
            perguntasPartida.add(associacao);
        });
        partidaPerguntaRepository.saveAll(perguntasPartida);
        return new DtoPartidaInicioResponse(partidaSalva.getIdPartida(), perguntasColetadas,
                partidaSalva.isFinalizada());
    }

    private void atualizarEstadoPartida(Partida partida, boolean acertou) {
        if (acertou) {
            partida.setPontuacao(partida.getPontuacao() + 10);
        } else {
            partida.setVidas(partida.getVidas() - 1);
        }
        partidaRepository.save(partida);
    }

    private void atualizarPontuacaoJogador(Partida partida, Jogador jogador) {
        int pontuacaoPartida = partida.getPontuacao();
        int pontuacaoMaximaJogador = jogador.getPontuacaoMaxima();

        if (pontuacaoPartida > pontuacaoMaximaJogador) {
            jogador.setPontuacaoMaxima(pontuacaoPartida);
            jogadorRepository.save(jogador);
        }
    }

    private void verificarFinalJogo(Partida partida) {
        boolean derrota = partida.getVidas() <= 0;
        long contagemPerguntasNaoRespondidas = partidaPerguntaRepository
                .countByPartidaIdAndRespondidaCorretamenteIsNull(partida.getIdPartida());
        boolean vitoria = contagemPerguntasNaoRespondidas == 0;

        if (derrota || vitoria) {
            partida.setFinalizada(true);
            partidaRepository.save(partida);
            atualizarPontuacaoJogador(partida, partida.getJogador());
        }
    }

    public DtoPartidaJogadaResponse responderPergunta(DtoPartidaJogadaInput dto) {
        Partida partidaAtual = partidaRepository.findById(dto.getIdPartida())
                .orElseThrow(() -> new NoSuchElementException(
                        "Partida com o id " + dto.getIdPartida() + " não encontrada, tente de novo"));

        PartidaPergunta associacao = partidaPerguntaRepository
                .findByPartidaIdAndPerguntaId(dto.getIdPartida(), dto.getIdPergunta())
                .orElseThrow(() -> new NoSuchElementException(
                        "essa pergunta não foi encontrada para estar associada a essa partida"));

        if (associacao.isRespondidaCorretamente() != null) {
            throw new IllegalArgumentException("Essa pergunta já foi respondida nessa partida");
        }

        DtoVerificacaoResposta dtoVerificacao = perguntaService.verificarResposta(associacao.getPergunta(),
                dto.getRespostaJogador());

        atualizarEstadoPartida(partidaAtual, dtoVerificacao.isAcertou());
        associacao.setRespondidaCorretamente(dtoVerificacao.isAcertou());
        partidaPerguntaRepository.save(associacao);
        verificarFinalJogo(partidaAtual);
        return new DtoPartidaJogadaResponse(
                dto.getIdPergunta(),
                dtoVerificacao,
                partidaAtual.getPontuacao(),
                partidaAtual.getVidas(),
                partidaAtual.isFinalizada());
    }
}