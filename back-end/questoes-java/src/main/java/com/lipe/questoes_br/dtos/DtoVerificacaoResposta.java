package com.lipe.questoes_br.dtos;

public class DtoVerificacaoResposta {
    private boolean acertou;
    private String resposta_correta;

    public DtoVerificacaoResposta(boolean acertou, String resposta_correta) {
        this.acertou = acertou;
        this.resposta_correta = resposta_correta;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    public String getResposta_correta() {
        return resposta_correta;
    }

    public void setResposta_correta(String resposta_correta) {
        this.resposta_correta = resposta_correta;
    }
}