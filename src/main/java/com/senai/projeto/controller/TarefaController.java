package com.senai.projeto.controller;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.dto.TarefaRequisicao;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.service.ProjetoService;
import com.senai.projeto.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public TarefaResposta cadastrarTarefa (@Valid @RequestBody TarefaRequisicao requisicao) {
        return service.cadastrarTarefa(requisicao);
    }

    @GetMapping
    public List<TarefaResposta> listarTarefas () {
        return service.listarTarefas();
    }

    @GetMapping("/id-titulo")
    public List<TarefaResposta> buscarPorIdTitulo (@RequestParam Long idProjeto, @RequestParam String titulo) {
        return service.buscarPorIdTitulo(idProjeto, titulo);
    }

    @GetMapping("/titulo")
    public List<TarefaResposta> buscarPorTitulo (@RequestParam String titulo) {
        return service.buscarPorTitulo(titulo);
    }
}
