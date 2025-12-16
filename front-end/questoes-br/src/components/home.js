import React from "react";
import Texto from "./Texto";
import { Link, useNavigate } from "react-router-dom";
import ApresentacaoJogo from './ApresentacaoJogo';
import Footer from './Footer'
import Header from './Header';

function Home() {
    let navigate = useNavigate();
    return (
        <div>
            <h1> Questoes_BR, venha se divertir aplicando tudo o que você já aprende! </h1>
            <Header></Header>
            <main>
                <Texto texto="aqui você poderá praticar o seu conhecimento respondendo a perguntas de diversas categorias, ganhando pontos e melhorando o seu conhecimento a cada jogo que finaliza!"></Texto>
                <Texto texto="você que está no ensino médio, fundamental, faculdade, já se sentiu cansado do modo de ensino tradicional nas escolas e universidades, no qual o professor apenas explica a matéria na frente da sala, você só ouve/enxerga o que ele escreve, tenta entender e anota? Acha que deveria haver algo um pouco mais interativo e prático para você aprender melhor?w"></Texto>
                <Texto texto="Se sua resposta foi sim a essa pergunta, seus problemas acabaram! Aqui no questões_BR, você tem perguntas de diferentes categorias para praticar o que você aprende, incluindo perguntas do ENEM!"></Texto>
                <Texto texto="Para o jogo ficar ainda mais divertido, aqui você também tem pontuação e vidas no jogo! Seu grande desafio é conseguir se manter vivo até o final do jogo, por isso estude bem o conteúdo para praticar!"></Texto>
                <Link to="/criacao"> crie um jogo! </Link>
            </main>
        </div>
    )
}

export default Home;