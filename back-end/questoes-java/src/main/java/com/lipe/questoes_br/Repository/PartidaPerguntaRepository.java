package com.lipe.questoes_br.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lipe.questoes_br.Entity.PartidaPergunta;

public interface PartidaPerguntaRepository extends JpaRepository<PartidaPergunta, Integer> {
    Optional<PartidaPergunta> findByPartidaIdAndPerguntaId(long partidaId, long perguntaId);

    long countByPartidaIdAndRespondidaCorretamenteIsNull(long partidaId);
}