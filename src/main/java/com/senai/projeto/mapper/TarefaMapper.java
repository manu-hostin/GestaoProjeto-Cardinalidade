package com.senai.projeto.mapper;


import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.dto.TarefaRequisicao;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.model.Projeto;
import com.senai.projeto.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TarefaMapper {

    public Tarefa paraEntidade (TarefaRequisicao requisicao) {
        return new Tarefa(
                requisicao.titulo(),
                requisicao.descricao(),
                requisicao.idProjeto()
        );
    }

    public TarefaResposta paraResposta (Tarefa tarefa) {
        return new TarefaResposta(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getProjeto().getId()
        );
    }

    public List<TarefaResposta> listar (List<Tarefa> tarefas) {
        List<TarefaResposta> lista = new ArrayList<>();

        for (Tarefa tarefa : tarefas){
            lista.add(paraResposta(tarefa));
        }
        return lista;
    }

}
