package com.senai.projeto.dto;

import jakarta.validation.constraints.NotNull;

public record ProjetoRequisicao(

        @NotNull(message = "Nome não pode ser nulo")
        String nome
) {}
