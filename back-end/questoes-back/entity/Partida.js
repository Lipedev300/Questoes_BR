/**
 * 
 * @param {string} id_jogador 
 * @param {string} apelido_jogador 
 * @param {number} pontuacao pontuação do jogador durante o jogo
 * @param {number} vidas vidas do jogador
 * @param {Array <object>} historico_respostas histórico das respostas do jogador
 * @returns {object} partida partida criada
 */

export function criar_partida(id_partida, id_jogador, apelido_jogador, pontuacao, vidas, historico_respostas) {
    return {
        id: id_partida,
        id_jogador: id_jogador,
        apelido_jogador: apelido_jogador,
        pontuacao: pontuacao,
        vidas: vidas,
        historico_respostas: historico_respostas
    };
}