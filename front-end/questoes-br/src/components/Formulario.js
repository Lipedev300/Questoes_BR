import { useState } from "react";

function Formulario() {
    const [apelido, setApelido] = useState("");
    const [quantidadePerguntas, setQuantidadePerguntas] = useState(0);

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

    return (
        <div>
            <form style={{ display: "flex", flexDirection: "column" }}>
                <label htmlFor="inputId"> Digite seu apelido para o jogo</label>
                <input id="apelidoId" type="text" value={apelido} onChange={atualizarApelido} placeholder="Digite seu apelido"></input>

                <label htmlFor="quantidadeId"> Selecione a quantidade de perguntas do jogo</label>
                <input id="quantidadeId" type="number" value={quantidadePerguntas} onChange={atualizarQuantidadePerguntas}></input>
                <button id="enviarId"> criar jogo</button>
            </form>
        </div>
    );
}

export default Formulario;