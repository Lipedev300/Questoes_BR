package com.lipe.questoes_br.dtos;

public class DtoPartidaResponse {
    private long id;
    private DtoVerificacaoResposta dtoResposta;
    private int pontuacao;
    private int vidas;

    public DtoPartidaResponse(DtoVerificacaoResposta dtoResposta, long id, int pontuacao, int vidas) {
        this.dtoResposta = dtoResposta;
        this.id = id;
        this.pontuacao = pontuacao;
        this.vidas = vidas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DtoVerificacaoResposta getDtoResposta() {
        return dtoResposta;
    }

    public void setDtoResposta(DtoVerificacaoResposta dtoResposta) {
        this.dtoResposta = dtoResposta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}