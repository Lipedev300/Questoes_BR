package com.lipe.questoes_br.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lipe.questoes_br.Entity.Pergunta;

public interface Pergunta_repository extends JpaRepository<Pergunta, Integer> {
    
}   