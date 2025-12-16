package com.lipe.questoes_br.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lipe.questoes_br.Service.JogadorService;
import com.lipe.questoes_br.Service.PartidaService;
import com.lipe.questoes_br.dtos.DtoJogadorResponse;
import com.lipe.questoes_br.dtos.DtoPartidaInicioResponse;
import com.lipe.questoes_br.dtos.DtoPartidaInput;
import com.lipe.questoes_br.dtos.DtoPartidaJogadaInput;
import com.lipe.questoes_br.dtos.DtoPartidaJogadaResponse;

@RestController
@RequestMapping("/quiz/jogos")

public class GameController {
    private final PartidaService partidaService;
    private final JogadorService jogadorService;

    public GameController(PartidaService partidaService, JogadorService jogadorService) {
        this.partidaService = partidaService;
        this.jogadorService = jogadorService;
    }

    @PostMapping("/iniciarjogo")
    public ResponseEntity<DtoPartidaInicioResponse> iniciarPartida(@RequestBody DtoPartidaInput dtoInput) {
        DtoPartidaInicioResponse partidaInicio = partidaService.iniciarPartida(dtoInput);
        return new ResponseEntity<>(partidaInicio, HttpStatus.CREATED);
    }

    @PostMapping("/{idPartida}/resposta")
    public ResponseEntity<DtoPartidaJogadaResponse> responderPergunta(@PathVariable long idPartida,
            @RequestBody DtoPartidaJogadaInput jogada) {
        DtoPartidaJogadaResponse feedback = partidaService.responderPergunta(jogada);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<DtoJogadorResponse>> obterRanking() {
        List<DtoJogadorResponse> rankingJogadores = jogadorService.retornarTop10();
        return new ResponseEntity<>(rankingJogadores, HttpStatus.OK);
    }

    @GetMapping("/live")
    public ResponseEntity<String> testeController() {
        return new ResponseEntity<>("Servidor executado e rodando com sucesso!", HttpStatus.OK);
    }
}