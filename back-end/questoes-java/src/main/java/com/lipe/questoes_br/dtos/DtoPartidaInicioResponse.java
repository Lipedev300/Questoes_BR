package com.lipe.questoes_br.dtos;

import java.util.List;

public class DtoPartidaInicioResponse {
    private long idPartida;
    private List<DtoPergunta> listaPerguntas;

    public DtoPartidaInicioResponse(long idPartida, List<DtoPergunta> listaPerguntas) {
        this.idPartida = idPartida;
        this.listaPerguntas = listaPerguntas;
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
}