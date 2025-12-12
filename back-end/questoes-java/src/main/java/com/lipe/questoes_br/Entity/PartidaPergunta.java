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

    @Column(columnDefinition = "boolean", nullable = false)
    private boolean respondida_corretamente;

    public PartidaPergunta() {

    }

    public PartidaPergunta(Partida partida, Pergunta pergunta, boolean respondida_corretamente) {
        this.partida = partida;
        this.pergunta = pergunta;
        this.respondida_corretamente = respondida_corretamente;
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

    public boolean isRespondida_corretamente() {
        return respondida_corretamente;
    }

    public void setRespondida_corretamente(boolean respondida_corretamente) {
        this.respondida_corretamente = respondida_corretamente;
    }

}