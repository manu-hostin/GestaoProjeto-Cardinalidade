package com.senai.projeto.dto;

public record TarefaResposta(
        Long id,
        String titulo,
        String descricao,
        Long idProjeto
) {}