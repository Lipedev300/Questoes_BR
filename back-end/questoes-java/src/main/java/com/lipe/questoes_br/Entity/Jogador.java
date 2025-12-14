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
    private int pontuacaoMaxima;

    @OneToMany(mappedBy = "jogador")
    private List<Partida> partidas = new ArrayList<>();

    public Jogador() {

    }

    public Jogador(long id, String apelido, int pontuacaoMaxima, List<Partida> partidas) {
        this.id = id;
        this.apelido = apelido;
        this.pontuacaoMaxima = pontuacaoMaxima;
        this.partidas = partidas;
    }

    public Jogador(String apelido) {
        this.apelido = apelido;
        this.pontuacaoMaxima = 0;
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

    public int getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }

    public void setPontuacaoMaxima(int pontuacaoMaxima) {
        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}