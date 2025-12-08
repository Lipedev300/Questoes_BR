package com.lipe.questoes_br.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lipe.questoes_br.Entity.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
    
}   