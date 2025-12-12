package com.lipe.questoes_br.dtos;

import java.util.Map;

public class DtoPergunta {
    private long id;
    private String categoria_pergunta;
    private String texto_pergunta;
    private Map<String, String> alternativas;

    public DtoPergunta(long id, String categoria_pergunta, String texto_pergunta, Map<String, String> alternativas) {
        this.id = id;
        this.categoria_pergunta = categoria_pergunta;
        this.texto_pergunta = texto_pergunta;
        this.alternativas = alternativas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Map<String, String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(Map<String, String> alternativas) {
        this.alternativas = alternativas;
    }
}