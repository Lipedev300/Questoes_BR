export function criarPergunta(id, categoria_pergunta, texto_pergunta, alternativas, resposta_correta) {
    return {
        id: undefined,
        categoria_pergunta: categoria_pergunta,
        texto_pergunta: texto_pergunta,
        alternativas: {},
        resposta_correta: resposta_correta
    };
}