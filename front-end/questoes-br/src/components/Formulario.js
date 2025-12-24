import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Formulario() {
    const [apelido, setApelido] = useState("");
    const [quantidadePerguntas, setQuantidadePerguntas] = useState(0);
    const navigate = useNavigate();

    const atualizarApelido = (event) => {
        const newValue = event.target.value;
        setApelido(newValue);
        console.log("Estado do apelido está sendo atualizado! ", newValue);
    }

    const atualizarQuantidadePerguntas = (event) => {
        const quantidade = event.target.value;
        setQuantidadePerguntas(quantidade);
        console.log("quantidade de perguntas está sendo atualizada! ", quantidade);
    }

    const criarJogo = async (event) => {
        event.preventDefault();

        try {
            const dadosPartida = {
                apelido: apelido,
                quantidadePerguntas: quantidadePerguntas
            }

            const response = await axios.post('http://127.0.0.1:8080/quiz/iniciarjogo', dadosPartida);
            console.log("Partida criada!", response.data);
            navigate('/jogo', { state: { partida: response.data } });
        } catch (error) {
            console.error("Erro ao criar jogo, tente novamente")
            alert("Erro ao criar jogo, não foi possível se conectar com o servidor, tente novamente");
        }
    }

    return (
        <div>
            <form onSubmit={criarJogo} style={{ display: "flex", flexDirection: "column" }}>
                <label htmlFor="inputId"> Digite seu apelido para o jogo</label>
                <input id="apelidoId" type="text" value={apelido} onChange={atualizarApelido} placeholder="Digite seu apelido"></input>

                <label htmlFor="quantidadeId"> Selecione a quantidade de perguntas do jogo</label>
                <input id="quantidadeId" type="number" value={quantidadePerguntas} onChange={atualizarQuantidadePerguntas}></input>
                <button id="enviarId" type="submit"> criar jogo</button>
            </form>
        </div>
    );
}

export default Formulario;