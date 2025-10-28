package com.lipe.questoes_br.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable= false, length= 30)
    private String categoria_pergunta;

    @Column(nullable = false, unique = true, columnDefinition= "TEXT")
    private String texto_pergunta;

    @Column(columnDefinition= "TEXT", nullable= false)
    private String alternativas;

    @Column(nullable= false, columnDefinition= "TEXT")
    private String resposta_correta;

    public Pergunta() {
        
    }

    public Pergunta(int id, String categoria_pergunta, String texto_pergunta, String alternativas,
            String resposta_correta) {
        this.id = id;
        this.categoria_pergunta = categoria_pergunta;
        this.texto_pergunta = texto_pergunta;
        this.alternativas = alternativas;
        this.resposta_correta = resposta_correta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria_pergunta() {
        return categoria_pergunta;
    }

    public void setCategoria_pergunta(String categoria_pergunta) {
        this.categoria_pergunta = categoria_pergunta;
    }

    public String getTexto_pergunta() {
        return texto_pergunta;
    }

    public void setTexto_pergunta(String texto_pergunta) {
        this.texto_pergunta = texto_pergunta;
    }

    public String getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String alternativas) {
        this.alternativas = alternativas;
    }

    public String getResposta_correta() {
        return resposta_correta;
    }

    public void setResposta_correta(String resposta_correta) {
        this.resposta_correta = resposta_correta;
    }   
}