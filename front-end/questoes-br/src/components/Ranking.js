import Header from './Header';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Ranking() {
    const navigate = useNavigate();
    const [listaJogadores, setListaJogadores] = useState([]);
    const [carregando, setCarregando] = useState(true);

    useEffect(() => {
        const buscarRanking = async () => {
            try {
                const response = await axios.get('/quiz/ranking');
                setListaJogadores(response.data);
            } catch (error) {
                console.error("Erro ao buscar dados de ranking", error);
            } finally {
                setCarregando(false);
            }
        }
        buscarRanking();
    }, []);
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
                <button onClick={() => navigate('/')}> voltar para a página inicial</button>
            </main>
        </div>
    )
}

export default Ranking;