package com.lipe.questoes_br.dtos;

public class DtoPartidaJogadaResponse {
    private long idPergunta;
    private DtoVerificacaoResposta dtoResposta;
    private int pontuacao;
    private int vidas;
    private boolean finalizada;

    public DtoPartidaJogadaResponse(long idPergunta, DtoVerificacaoResposta dtoResposta, int pontuacao, int vidas,
            boolean finalizada) {
        this.idPergunta = idPergunta;
        this.dtoResposta = dtoResposta;
        this.pontuacao = pontuacao;
        this.vidas = vidas;
        this.finalizada = finalizada;
    }

    public long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(long idPergunta) {
        this.idPergunta = idPergunta;
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

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}