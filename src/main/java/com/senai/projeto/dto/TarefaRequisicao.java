package com.senai.projeto.dto;

import jakarta.validation.constraints.NotNull;

public record TarefaRequisicao(

        @NotNull(message = "Título não pode ser nulo")
        String titulo,

        @NotNull(message = "Descrição não pode ser nulo")
        String descricao,
        Long idProjeto
) {}