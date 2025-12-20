package com.lipe.questoes_br.dtos;

public class DtoJogadorResponse {
    private String apelido;
    private int pontuacao_maxima;

    public DtoJogadorResponse(String apelido, int pontuacao_maxima) {
        this.apelido = apelido;
        this.pontuacao_maxima = pontuacao_maxima;
    }

    public DtoJogadorResponse() {

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
}