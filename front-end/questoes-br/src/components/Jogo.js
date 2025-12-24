import Texto from './Texto';
import { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

function Jogo() {
    const location = useLocation();
    let partida = location.state.partida;
    let [indicePergunta, setIndicePergunta] = useState(0);
    let [respostaSelecionada, setRespostaSelecionada] = useState("");
    const perguntaAtual = partida.listaPerguntas[indicePergunta];

    if (!partida) {
        return <p> carregando perguntas...</p>
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
            </main>
        </div>
    )
}

export default Jogo;