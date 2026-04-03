package com.senai.projeto.controller;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.service.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ProjetoResposta cadastrarProjeto (@Valid @RequestBody ProjetoRequisicao requisicao) {
        return service.cadastrarTarefa(requisicao);
    }

    @GetMapping
    public List<ProjetoResposta> listarProjetos () {
        return service.listarProjetos();
    }

    @GetMapping("/nome")
    public List<ProjetoResposta> listarPorNome (@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }


}
