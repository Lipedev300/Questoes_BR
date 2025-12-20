package com.lipe.questoes_br.Service;

import java.util.List;
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
import com.lipe.questoes_br.dtos.DtoPartidaInicioResponse;
import com.lipe.questoes_br.dtos.DtoPartidaInput;
import com.lipe.questoes_br.dtos.DtoPartidaJogadaResponse;
import com.lipe.questoes_br.dtos.DtoPergunta;
import com.lipe.questoes_br.dtos.DtoVerificacaoResposta;
import com.lipe.questoes_br.dtos.MapperDtos;

@Service
public class PartidaService {
    private final JogadorRepository jogadorRepository;
    private final PartidaRepository partidaRepository;
    private final PartidaPerguntaRepository partidaPerguntaRepository;
    private final PerguntaService perguntaService;
    private final MapperDtos mapperDtos;

    public PartidaService(JogadorRepository jogadorRepository, PartidaRepository partidaRepository,
            PartidaPerguntaRepository partidaPerguntaRepository,
            PerguntaService perguntaService, MapperDtos mapperDtos) {
        this.jogadorRepository = jogadorRepository;
        this.partidaRepository = partidaRepository;
        this.partidaPerguntaRepository = partidaPerguntaRepository;
        this.perguntaService = perguntaService;
        this.mapperDtos = mapperDtos;
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
        List<Pergunta> perguntasColetadas = perguntaService.coletarPerguntas(dtoInput.getQuantidadePerguntas());

        // criando associações entre a partida e as perguntas//
        List<PartidaPergunta> perguntasPartida = perguntasColetadas.stream()
                .map(pergunta -> new PartidaPergunta(partidaSalva, pergunta, null))
                .collect(Collectors.toList());

        partidaPerguntaRepository.saveAll(perguntasPartida);

        // convertendo a lista para DTOs//
        List<DtoPergunta> perguntasJogo = perguntasColetadas.stream()
                .map(mapperDtos::entityToPerguntaDto)
                .toList();
        return new DtoPartidaInicioResponse(partidaSalva.getIdPartida(), perguntasJogo,
                partidaSalva.isFinalizada(), jogador.getApelido());
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
                .contarPerguntasNãoRespondidas(partida.getIdPartida());
        boolean vitoria = contagemPerguntasNaoRespondidas == 0;

        if (derrota || vitoria) {
            partida.setFinalizada(true);
            partidaRepository.save(partida);
            atualizarPontuacaoJogador(partida, partida.getJogador());
        }
    }

    public DtoPartidaJogadaResponse responderPergunta(long idPartida, long idPergunta, String respostaJogador) {
        Partida partidaAtual = partidaRepository.findById(idPartida)
                .orElseThrow(() -> new NoSuchElementException(
                        "Partida com o id " + idPartida + " não encontrada, tente de novo"));

        if (partidaAtual.isFinalizada()) {
            throw new IllegalStateException(
                    "Essa partida não pode ser mais jogada, pois já está finalizada. Você não pode responder perguntas aqui");
        }

        PartidaPergunta associacao = partidaPerguntaRepository
                .buscarPorPartidaEPergunta(idPartida, idPergunta)
                .orElseThrow(() -> new NoSuchElementException(
                        "essa pergunta não foi encontrada para estar associada a essa partida"));

        if (associacao.isRespondidaCorretamente() != null) {
            throw new IllegalArgumentException("Essa pergunta já foi respondida nessa partida");
        }

        DtoVerificacaoResposta dtoVerificacao = perguntaService.verificarResposta(associacao.getPergunta(),
                respostaJogador);

        atualizarEstadoPartida(partidaAtual, dtoVerificacao.isAcertou());
        associacao.setRespondidaCorretamente(dtoVerificacao.isAcertou());
        partidaPerguntaRepository.save(associacao);
        verificarFinalJogo(partidaAtual);
        return new DtoPartidaJogadaResponse(
                idPergunta,
                dtoVerificacao,
                partidaAtual.getPontuacao(),
                partidaAtual.getVidas(),
                partidaAtual.isFinalizada());
    }
}