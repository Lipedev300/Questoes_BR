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
    private long id_partida;

    @ManyToOne
    @JoinColumn(name = "id_jogador", nullable = false)
    private Jogador jogador;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int pontuacao;

    @Column(columnDefinition = "integer default 3")
    private int vidas;

    public Partida() {

    }

    public Partida(long id_partida, Jogador jogador, int pontuacao, int vidas) {
        this.id_partida = id_partida;
        this.jogador = jogador;
        this.pontuacao = pontuacao;
        this.vidas = vidas;
    }

    public long getId_partida() {
        return id_partida;
    }

    public void setId_partida(long id_partida) {
        this.id_partida = id_partida;
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

}