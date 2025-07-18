package model;

public class Jogador {
    private String apelido;
    private int pontuacao;
    private int posicaoNoTabuleiro;
    private int voltasCompletas;

    public Jogador(String apelido) {
        this.apelido = apelido;
        this.pontuacao = 0;
        this.posicaoNoTabuleiro = 0;
        this.voltasCompletas = 0;
    }

    public int lancarDado() {
        return 0;
    }

    public void moverJogador(int casas) {

    }

    public void ganharPontos(int pontos) {
        this.pontuacao += pontos;
    }

    public void perderPontos(int pontos) {
        this.pontuacao -= pontos;
    }   

    public String getApelido() {
        return apelido;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getPosicaoNoTabuleiro() {
        return posicaoNoTabuleiro;
    }

    public int getVoltasCompletas() {
        return voltasCompletas;
    }

    public void setPosicaoNoTabuleiro(int posicaoNoTabuleiro) {
        this.posicaoNoTabuleiro = posicaoNoTabuleiro;
    }

    public void setVoltasCompletas(int voltasCompletas) {
        this.voltasCompletas = voltasCompletas;
    }
}