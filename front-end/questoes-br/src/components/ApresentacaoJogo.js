import Texto from "./Texto";
import Footer from './Footer';
import Header from './Header';

function ApresentacaoJogo() {
    return (
        <div>
            <h1> tela de apresentação do jogo</h1>
            <Header></Header>
            <main>
                <Texto texto="Conheça mais sobre o jogo Questões_BR!"></Texto>
                <Texto texto="este é um jogo de quiz onde você poderá praticar os assuntos que você estuda de forma divertida, com feedback de desempenho, pontuação e vidas para tornar a experiência agradável para jogar"></Texto>
                <br></br>
                <Texto texto="Principais funcionalidades e modo de jogar"></Texto>
                <ul>
                    <li>
                        <Texto texto="perguntas de diferentes categorias, você escolhe o que quer praticar. No momento, porém, só está disponível o jogo com perguntas aleatórias, mas isso irá mudar nas próximas versões."></Texto>
                    </li>
                    <li>
                        <Texto texto="você sempre terá feedback textual e sonoro a respeito de seu desempenho nas respostas."></Texto>
                    </li>
                    <li>
                        <Texto texto="você também terá um ranking disponível para os 10 melhores jogadores, vendo nomes e pontuações máximas"></Texto>
                    </li>
                </ul>
                <br></br>
                <Texto texto="modo de jogar"></Texto>
                <ol>
                    <li>
                        <Texto texto="você começa definindo seu nome/apelido no jogo, e quantidade de perguntas que deseja responder nessa partida"></Texto>
                    </li>
                    <li>
                        <Texto texto="Após isso, você já tem as perguntas disponíveis para responder!"></Texto>
                    </li>
                    <li>
                        <Texto texto="No início do jogo, você começa com 0 pontos e 3 vidas."></Texto>
                    </li>
                    <li>
                        <Texto texto="cada pergunta certa te dá 10 pontos, mas cuidado, cada resposta errada te tira uma vida! Fique atento!"></Texto>
                    </li>
                    <li>
                        <Texto texto="A cada pergunta respondida, você terá feedback sobre seu desempenho na resposta, e será constantemente atualizado quanto a sua pontuação e vidas"></Texto>
                    </li>
                    <li>
                        <Texto texto="Se você perder todas as vidas, você terá que doar um pouco da sua pontuação que você acumulou para reviver. Mas fique atento que essa função ainda não foi implementada, por isso cuidado! Se você perder todas as vidas, nessa primeira versão é fim de jogo!"></Texto>
                    </li>
                    <li>
                        <Texto texto="Ao final do jogo você também será notificado sobre sua pontuação e vidas, e sua pontuação, caso seja a máxima que você já conseguiu, será salva em um ranking"></Texto>
                    </li>
                </ol>
            </main>
            <footer></footer>
        </div>
    )
}

export default ApresentacaoJogo;