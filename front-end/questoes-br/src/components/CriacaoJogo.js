import Texto from './Texto';
import Formulario from './Formulario';

function CriacaoJogo() {
    return (
        <div>
            <h1> Tela de criação de jogo</h1>
            <Texto Texto="defina seus dados como apelido e quantidade de perguntas para iniciar um jogo novo"></Texto>
            <Formulario></Formulario>
        </div>
    )
}

export default CriacaoJogo;