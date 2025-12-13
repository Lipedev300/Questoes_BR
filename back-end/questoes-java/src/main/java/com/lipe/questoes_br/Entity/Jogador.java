package com.lipe.questoes_br.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 25)
    private String apelido;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int pontuacao_maxima;

    @OneToMany(mappedBy = "jogador")
    private List<Partida> partidas = new ArrayList<>();

    public Jogador() {

    }

    public Jogador(long id, String apelido, int pontuacao_maxima, List<Partida> partidas) {
        this.id = id;
        this.apelido = apelido;
        this.pontuacao_maxima = pontuacao_maxima;
        this.partidas = partidas;
    }

    public Jogador(String apelido) {
        this.apelido = apelido;
        this.pontuacao_maxima = 0;
        this.partidas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getPontuacao_maxima() {
        return pontuacao_maxima;
    }

    public void setPontuacao_maxima(int pontuacao_maxima) {
        this.pontuacao_maxima = pontuacao_maxima;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}