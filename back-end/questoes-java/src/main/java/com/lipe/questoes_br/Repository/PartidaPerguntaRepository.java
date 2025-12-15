package com.lipe.questoes_br.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lipe.questoes_br.Entity.PartidaPergunta;

public interface PartidaPerguntaRepository extends JpaRepository<PartidaPergunta, Integer> {
    @Query("SELECT pp from PartidaPergunta pp WHERE pp.partida.idPartida = :partidaId AND pp.pergunta.id = :perguntaId")
    Optional<PartidaPergunta> buscarPorPartidaEPergunta(
            @Param("partidaId") long partidaId,
            @Param("perguntaId") long perguntaId);

    @Query("SELECT COUNT(pp) from PartidaPergunta pp WHERE pp.partida.idPartida = :partidaId AND pp.respondidaCorretamente IS NULL")
    long contarPerguntasNãoRespondidas(@Param("partidaId") long partidaId);
}