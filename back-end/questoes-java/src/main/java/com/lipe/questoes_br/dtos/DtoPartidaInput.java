package com.lipe.questoes_br.dtos;

public class DtoPartidaInput {
    private String apelido;
    private int quantidadePerguntas;

    public DtoPartidaInput(String apelido, int quantidadePerguntas) {
        this.apelido = apelido;
        this.quantidadePerguntas = quantidadePerguntas;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getQuantidadePerguntas() {
        return quantidadePerguntas;
    }

    public void setQuantidadePerguntas(int quantidadePerguntas) {
        this.quantidadePerguntas = quantidadePerguntas;
    }
}