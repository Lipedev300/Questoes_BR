package com.lipe.questoes_br.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lipe.questoes_br.Entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    Optional<Jogador> findByApelido(String apelido);

    List<Jogador> findTop10ByOrderByPontuacaoMaximaDesc();
}