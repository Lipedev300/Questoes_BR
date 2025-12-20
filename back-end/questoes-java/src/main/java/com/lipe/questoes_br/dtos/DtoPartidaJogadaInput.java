package com.lipe.questoes_br.dtos;

public class DtoPartidaJogadaInput {
    private String respostaJogador;

    public DtoPartidaJogadaInput(String respostaJogador) {
        this.respostaJogador = respostaJogador;
    }

    public DtoPartidaJogadaInput() {

    }

    public String getRespostaJogador() {
        return respostaJogador;
    }

    public void setRespostaJogador(String respostaJogador) {
        this.respostaJogador = respostaJogador;
    }
}