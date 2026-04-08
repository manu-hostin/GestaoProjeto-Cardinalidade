package com.senai.projeto.controller;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResposta> cadastrarProjeto (@Valid @RequestBody ProjetoRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrarTarefa(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResposta>> listarProjetos () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarProjetos());
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ProjetoResposta>> listarPorNome (@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorNome(nome));
    }


}
