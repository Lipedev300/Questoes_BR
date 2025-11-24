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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable= false, length= 30)
    private String nome_completo;

    @Column (unique= true, nullable= false, length= 25)
    private String nome_usuario;

    @Column (unique= true, nullable= false, length= 50)
    private String email;

    @Column (unique= true, nullable= false, length= 20)
    private String senha;

    @Column(columnDefinition= "integer default 0", nullable= false)
    private int pontuacao_maxima;

    @OneToMany(mappedBy= "jogador")
    private List<Partida> partidas = new ArrayList<>();

    public Jogador() {
        
    }

    public Jogador(String nome_completo, String nome_usuario, String email, String senha, int pontuacao_maxima) {
        this.nome_completo = nome_completo;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.pontuacao_maxima = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPontuacao_maxima(int pontuacao_maxima) {
        this.pontuacao_maxima = pontuacao_maxima;
    }   
}