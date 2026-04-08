package com.senai.projeto.controller;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.dto.TarefaRequisicao;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.service.ProjetoService;
import com.senai.projeto.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResposta> cadastrarTarefa (@Valid @RequestBody TarefaRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrarTarefa(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResposta>> listarTarefas () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarTarefas());
    }

    @GetMapping("/id-titulo")
    public ResponseEntity<List<TarefaResposta>> buscarPorIdTitulo (@RequestParam Long idProjeto, @RequestParam String titulo) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorIdTitulo(idProjeto, titulo));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<TarefaResposta>> buscarPorTitulo (@RequestParam String titulo) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorTitulo(titulo));
    }
}
