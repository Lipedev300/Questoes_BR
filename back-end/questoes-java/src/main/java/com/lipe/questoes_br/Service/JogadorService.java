package com.lipe.questoes_br.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lipe.questoes_br.Entity.Jogador;
import com.lipe.questoes_br.Repository.JogadorRepository;
import com.lipe.questoes_br.dtos.DtoJogadorResponse;
import com.lipe.questoes_br.dtos.MapperDtos;

@Service
public class JogadorService {
    private final JogadorRepository repository;
    private final MapperDtos mapeador;

    public JogadorService(JogadorRepository repository, MapperDtos mapeador) {
        this.repository = repository;
        this.mapeador = mapeador;
    }

    public Jogador buscarApelido(String apelido) {
        Optional<Jogador> jogadorExistente = repository.findByApelido(apelido);
        if (jogadorExistente.isPresent()) {
            return jogadorExistente.get();
        } else {
            Jogador jogador = new Jogador();
            jogador.setApelido(apelido);
            jogador.setPontuacaoMaxima(0);
            repository.save(jogador);
            return jogador;
        }
    }

    public List<DtoJogadorResponse> retornarTop10() {
        List<Jogador> listaJogadores = repository.findTop10ByOrderByPontuacaoMaximaDesc();
        List<DtoJogadorResponse> lista_dtos = listaJogadores.stream().map(jogador -> {
            return this.mapeador.entityToDtoJogador(jogador);
        }).toList();
        return lista_dtos;
    }
}