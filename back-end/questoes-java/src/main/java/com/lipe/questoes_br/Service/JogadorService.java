package com.lipe.questoes_br.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lipe.questoes_br.Entity.Jogador;
import com.lipe.questoes_br.Repository.JogadorRepository;

@Service
public class JogadorService {
    private final JogadorRepository repository;

    public JogadorService(JogadorRepository repository) {
        this.repository = repository;
    }

    public Jogador buscarApelido(String apelido) {
        Optional<Jogador> jogadorExistente = repository.findByApelido(apelido);
        if (jogadorExistente.isPresent()) {
            return jogadorExistente.get();
        } else {
            Jogador jogador = new Jogador();
            jogador.setApelido(apelido);
            jogador.setPontuacao_maxima(0);
            repository.save(jogador);
            return jogador;
        }
    }
}
