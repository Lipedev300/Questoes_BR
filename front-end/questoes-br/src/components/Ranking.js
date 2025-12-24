import Header from './Header';

function ranking({ listaJogadores = [] }) {
    return (
        <div>
            <h2> Lista de jogadores no ranking, ordenados por pontuação máxima decrescente</h2>
            <Header></Header>
            <main>
                {listaJogadores.length === 0 ? (
                    <p> Nenhum jogador ainda no ranking, jogue uma partida primeiro</p>
                ) : (
                    <ul>
                        {listaJogadores.map((jogador, index) => {
                            return <li key={index}> {jogador.apelido} - {jogador.pontuacao_maxima} pontos</li>
                        })}
                    </ul>
                )}
            </main>

        </div>
    )
}

export default ranking;