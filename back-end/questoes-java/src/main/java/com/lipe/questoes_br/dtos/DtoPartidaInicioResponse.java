package com.lipe.questoes_br.dtos;

import java.util.List;

public class DtoPartidaInicioResponse {
    private long idPartida;
    private List<DtoPergunta> listaPerguntas;
    private boolean finalizada;
    private String apelidoJogador;

    public DtoPartidaInicioResponse(long idPartida, List<DtoPergunta> listaPerguntas, boolean finalizada,
            String apelidoJogador) {
        this.idPartida = idPartida;
        this.listaPerguntas = listaPerguntas;
        this.finalizada = finalizada;
        this.apelidoJogador = apelidoJogador;
    }

    public long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(long idPartida) {
        this.idPartida = idPartida;
    }

    public List<DtoPergunta> getListaPerguntas() {
        return listaPerguntas;
    }

    public void setListaPerguntas(List<DtoPergunta> listaPerguntas) {
        this.listaPerguntas = listaPerguntas;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public String getApelidoJogador() {
        return apelidoJogador;
    }

    public void setApelidoJogador(String apelidoJogador) {
        this.apelidoJogador = apelidoJogador;
    }

}