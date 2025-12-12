package com.lipe.questoes_br.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lipe.questoes_br.Entity.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
    
    @Query(value="SELECT * FROM pergunta order by Random() LIMIT ?1", nativeQuery= true)
    List<Pergunta> coletarPerguntas(int quantidade);
}   