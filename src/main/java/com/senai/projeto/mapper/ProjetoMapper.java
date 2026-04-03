package com.senai.projeto.mapper;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.model.Projeto;
import com.senai.projeto.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjetoMapper {

    public Projeto paraEntidade (ProjetoRequisicao requisicao) {
        return new Projeto(
                requisicao.nome()
        );
    }

    public ProjetoResposta paraResposta (Projeto projeto) {
        return new ProjetoResposta(
                projeto.getId(),
                projeto.getNome()
        );
    }

    public List<ProjetoResposta> listar (List<Projeto> projetos) {
        List<ProjetoResposta> lista = new ArrayList<>();

        for (Projeto projeto : projetos){
            lista.add(paraResposta(projeto));
        }
        return lista;
    }
}
