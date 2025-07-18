package model;

import java.util.List;

public class Pergunta {
    private String textoPergunta;
    private List<String> opcoesResposta;
    private String respostaCorreta;
    private String categoria;

    public Pergunta(String textoPergunta, List<String> opcoesResposta, String respostaCorreta, String categoria) {
        this.textoPergunta = textoPergunta;
        this.opcoesResposta = opcoesResposta;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
    }   

    public boolean verificarResposta(String respostaDoJogador) {
        return this.respostaCorreta.equalsIgnoreCase(respostaDoJogador.trim());
    }

    public String getTextoPergunta() {
        return textoPergunta;
    }   

    public List<String> getOpcoesResposta() {
        return opcoesResposta;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public String getCategoria() {
        return categoria;
    }
}