package com.lipe.questoes_br.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import com.lipe.questoes_br.dtos.DtoPergunta;

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
        return new DtoPartidaInicioResponse(partidaSalva.getId_partida(), perguntasColetadas);
    }
}