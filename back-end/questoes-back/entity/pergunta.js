/**
 * @param {number} id id da pergunta
 * @param {string} categoria_pergunta 
 * @param {string} texto_pergunta 
 * @param {object} alternativas 
 * @param {string} resposta_correta 
 * @returns {object} pergunta
 */

export function criarPergunta(id, categoria_pergunta, texto_pergunta, alternativas, resposta_correta) {
    return {
        id_pergunta: id,
        categoria_pergunta: categoria_pergunta,
        texto_pergunta: texto_pergunta,
        alternativas: alternativas,
        resposta_correta: resposta_correta
    };
}