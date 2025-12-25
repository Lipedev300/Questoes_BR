import Texto from './Texto';
import { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';

function Jogo() {
    const location = useLocation();
    const navigate = useNavigate();
    let partida = location.state.partida;
    let [indicePergunta, setIndicePergunta] = useState(0);
    let [respostaSelecionada, setRespostaSelecionada] = useState("");
    const perguntaAtual = partida.listaPerguntas[indicePergunta];

    if (!partida) {
        return <p> carregando perguntas...</p>
    }

    const enviarResposta = async () => {
        const somAcerto = new Audio('/sons/palmas.mp3');
        const somErro = new Audio('/sons/error.mp3');

        const corpoResposta = {
            respostaJogador: respostaSelecionada
        }

        try {
            const response = await axios.post(`/quiz/${partida.idPartida}/perguntas/${perguntaAtual.id}/resposta`, corpoResposta);
            const desempenho = response.data;

            if (desempenho.dtoResposta.acertou) {
                somAcerto.play();
                alert(`Parabéns, você acertou! Sua pontuação agora é de ${desempenho.pontuacao}`);
            } else {
                somErro.play();
                alert(`Que pena, não foi dessa vez. A resposta correta era ${desempenho.dtoResposta.resposta_correta}. Você perdeu uma vida, e a sua quantidade atual de vidas é ${desempenho.vidas}`);
            }

            if (desempenho.finalizada) {
                alert(`Fim de jogo! Você terminou com ${desempenho.pontuacao} pontos e ${desempenho.vidas} vidas. Vamos ver agora como você se encaixa no ranking!`);
                navigate('/ranking');
            } else {
                setIndicePergunta(indicePergunta + 1);
                setRespostaSelecionada("");
            }
        } catch (error) {
            console.error("Erro ao processar resposta", error);
            alert("Erro ao processar a sua resposta, verifique a sua conexão com a internet e tente novamente");
        }
    }
    return (
        <div>
            <h1> Página de jogo</h1>
            <Texto texto="é hora da prática! Comece já a responder as perguntas."></Texto>
            <Texto texto={`Boa sorte, ${partida.apelido}!`}></Texto>
            <main>
                <h2> {perguntaAtual.texto_pergunta}</h2>

                <div>
                    <label htmlFor='selecaoAlternativas'> Selecione uma opção</label>
                    <br></br>

                    <select
                        id='selecaoAlternativas'
                        value={respostaSelecionada}
                        onChange={(event) => setRespostaSelecionada(event.target.value)}
                    >
                        <option value=""> -- selecione uma alternativa -- </option>
                        {Object.entries(perguntaAtual.alternativas).map(([letra, texto]) => (
                            <option key={letra} value={letra}>
                                {letra}) {texto}
                            </option>
                        ))}
                    </select>
                </div>
                <button onClick={enviarResposta} disabled={!respostaSelecionada}> verificar resposta</button>
            </main>
        </div>
    )
}

export default Jogo;