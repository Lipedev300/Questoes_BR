package com.lipe.questoes_br.dtos;

import org.springframework.stereotype.Component;

import com.lipe.questoes_br.Entity.Jogador;
import com.lipe.questoes_br.Entity.Partida;
import com.lipe.questoes_br.Service.JogadorService;

@Component
public class MapperDtos {
    private final JogadorService service;

    public MapperDtos(JogadorService service) {
        this.service = service;
    }

    public Jogador gamerDtoToEntity(DtoPartidaInput dto) {
        return service.buscarApelido(dto.getApelido());
    }

    public DtoJogadorResponse entityToDtoJogador(Jogador jogador) {
        String apelido = jogador.getApelido();
        int pontuacao_maxima = jogador.getPontuacao_maxima();
        return new DtoJogadorResponse(apelido, pontuacao_maxima);
    }

    public DtoPartidaResponse entityToPartidaDto(Partida partida, DtoVerificacaoResposta resultadoPergunta) {
        long id = partida.getId_partida();
        int pontuacao = partida.getPontuacao();
        int vidas = partida.getVidas();
        return new DtoPartidaResponse(id, resultadoPergunta, pontuacao, vidas);
    }
}