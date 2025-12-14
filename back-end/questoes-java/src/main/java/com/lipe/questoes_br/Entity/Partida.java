package com.lipe.questoes_br.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPartida;

    @ManyToOne
    @JoinColumn(name = "id_jogador", nullable = false)
    private Jogador jogador;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int pontuacao;

    @Column(columnDefinition = "integer default 3")
    private int vidas;

    @Column(columnDefinition = "boolean", nullable = false)
    private boolean finalizada = false;

    public Partida() {

    }

    public Partida(long idPartida, Jogador jogador, int pontuacao, int vidas, boolean finalizada) {
        this.idPartida = idPartida;
        this.jogador = jogador;
        this.pontuacao = pontuacao;
        this.vidas = vidas;
        this.finalizada = finalizada;
    }

    public Partida(Jogador jogador) {
        this.jogador = jogador;
        this.pontuacao = 0;
        this.vidas = 3;
    }

    public long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(long idPartida) {
        this.idPartida = idPartida;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}