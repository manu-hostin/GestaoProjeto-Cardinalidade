package com.senai.projeto.repository;

import com.senai.projeto.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByTitulo (String titulo);

    List<Tarefa> findByProjetoIdAndTitulo(Long idProjeto, String titulo);
}