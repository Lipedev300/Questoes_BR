package com.lipe.questoes_br.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lipe.questoes_br.Entity.Pergunta;
import com.lipe.questoes_br.Repository.PerguntaRepository;
import com.lipe.questoes_br.dtos.DtoVerificacaoResposta;
import com.lipe.questoes_br.dtos.MapperDtos;

@Service
public class PerguntaService {
    private final PerguntaRepository repository;

    public PerguntaService(PerguntaRepository repository, MapperDtos mapperDtos) {
        this.repository = repository;
    }

    public DtoVerificacaoResposta verificarResposta(Pergunta pergunta, String respostaJogador) {
        String respostaCerta = pergunta.getResposta_correta().trim().toLowerCase();
        String respostaCliente = respostaJogador.trim().toLowerCase();
        boolean acertou = respostaCliente.equals(respostaCerta);

        String respostaCertaRetornada;

        if (acertou) {
            respostaCertaRetornada = null;
        } else {
            respostaCertaRetornada = pergunta.getResposta_correta();
        }

        return new DtoVerificacaoResposta(acertou, respostaCertaRetornada);
    }

    public List<Pergunta> coletarPerguntas(int quantidade) {
        List<Pergunta> perguntasColetadas = repository.coletarPerguntas(quantidade);
        return perguntasColetadas;
    }
}