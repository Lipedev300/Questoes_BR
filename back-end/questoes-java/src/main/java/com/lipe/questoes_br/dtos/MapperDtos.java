package com.lipe.questoes_br.dtos;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lipe.questoes_br.Entity.Jogador;
import com.lipe.questoes_br.Entity.Partida;
import com.lipe.questoes_br.Entity.Pergunta;
import com.lipe.questoes_br.Service.JogadorService;

@Component
public class MapperDtos {
    private final JogadorService service;
    private final ObjectMapper objectMapper;

    public MapperDtos(JogadorService service, ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    public Jogador gamerDtoToEntity(DtoPartidaInput dto) {
        return service.buscarApelido(dto.getApelido());
    }

    public DtoJogadorResponse entityToDtoJogador(Jogador jogador) {
        String apelido = jogador.getApelido();
        int pontuacao_maxima = jogador.getPontuacao_maxima();
        return new DtoJogadorResponse(apelido, pontuacao_maxima);
    }

    public DtoPartidaJogadaResponse entityToPartidaDto(Partida partida, DtoVerificacaoResposta resultadoPergunta) {
        long id = partida.getIdPartida();
        int pontuacao = partida.getPontuacao();
        int vidas = partida.getVidas();
        boolean finalizada = partida.isFinalizada();
        return new DtoPartidaJogadaResponse(id, resultadoPergunta, pontuacao, vidas, finalizada);
    }

    public DtoPergunta entityToPerguntaDto(Pergunta pergunta) {
        long id = pergunta.getId();
        String categoria_pergunta = pergunta.getCategoria_pergunta();
        String texto_pergunta = pergunta.getTexto_pergunta();
        String alternativasJson = pergunta.getAlternativas();

        Map<String, String> alternativasObject;

        try {
            alternativasObject = objectMapper.readValue(alternativasJson, new TypeReference<Map<String, String>>() {
            });
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao converter alternativas para objeto");
            e.getMessage();
            throw new RuntimeException("Erro interno ao descerializar dados de alternativas para a pergunta com id "
                    + id + " tente novamente", e);
        }
        return new DtoPergunta(id, categoria_pergunta, texto_pergunta, alternativasObject);
    }
}