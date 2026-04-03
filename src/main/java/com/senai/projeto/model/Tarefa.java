package com.senai.projeto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Projeto projeto;

    public Tarefa(String titulo, String descricao, Long idProjeto) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}