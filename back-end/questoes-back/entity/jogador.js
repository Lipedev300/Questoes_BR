/**
 * @param {string} id id do jogador
 * @returns {object} jogador jogador criado
*/

export function criar_jogador(id, apelido, pontuacao_maxima) {
    return {
        id_jogador: id,
        apelido: apelido,
        pontuacao_maxima: pontuacao_maxima
    };
}