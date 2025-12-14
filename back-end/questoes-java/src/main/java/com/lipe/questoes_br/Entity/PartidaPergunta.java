package com.lipe.questoes_br.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PartidaPergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "partida_id", nullable = false)
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "pergunta_id", nullable = false)
    private Pergunta pergunta;

    @Column(columnDefinition = "Boolean", nullable = true)
    private Boolean respondidaCorretamente;

    public PartidaPergunta() {

    }

    public PartidaPergunta(Partida partida, Pergunta pergunta, Boolean respondidaCorretamente) {
        this.partida = partida;
        this.pergunta = pergunta;
        this.respondidaCorretamente = respondidaCorretamente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Boolean isRespondidaCorretamente() {
        return respondidaCorretamente;
    }

    public void setRespondidaCorretamente(Boolean respondidaCorretamente) {
        this.respondidaCorretamente = respondidaCorretamente;
    }
}