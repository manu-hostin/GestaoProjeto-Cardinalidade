package com.senai.projeto.service;

import com.senai.projeto.dto.ProjetoRequisicao;
import com.senai.projeto.dto.ProjetoResposta;
import com.senai.projeto.dto.TarefaRequisicao;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.mapper.ProjetoMapper;
import com.senai.projeto.mapper.TarefaMapper;
import com.senai.projeto.model.Projeto;
import com.senai.projeto.model.Tarefa;
import com.senai.projeto.repository.ProjetoRepository;
import com.senai.projeto.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoService {
    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoService(ProjetoRepository repository, ProjetoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProjetoResposta cadastrarTarefa (ProjetoRequisicao requisicao) {
        Projeto projeto = mapper.paraEntidade(requisicao);

        Projeto salvar = repository.save(projeto);
        return mapper.paraResposta(projeto);
    }

    public List<ProjetoResposta> listarProjetos () {
        List<Projeto> projetos = repository.findAll();
        List<ProjetoResposta> projetoRespostas = new ArrayList<>();

        for (Projeto projeto : projetos){
            projetoRespostas.add(mapper.paraResposta(projeto));
        }

        return projetoRespostas;
    }

    // Filtros
    public List<ProjetoResposta> buscarPorNome (String nome) {
        List<Projeto> projetos = repository.findByNome(nome);
        return mapper.listar(projetos);
    }

}
