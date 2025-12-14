package com.lipe.questoes_br.dtos;

public class DtoPartidaJogadaInput {
    private long idPartida;
    private long idPergunta;
    private String respostaJogador;

    public DtoPartidaJogadaInput(long idPartida, long idPergunta, String respostaJogador) {
        this.idPartida = idPartida;
        this.idPergunta = idPergunta;
        this.respostaJogador = respostaJogador;
    }

    public long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(long idPartida) {
        this.idPartida = idPartida;
    }

    public long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getRespostaJogador() {
        return respostaJogador;
    }

    public void setRespostaJogador(String respostaJogador) {
        this.respostaJogador = respostaJogador;
    }
}