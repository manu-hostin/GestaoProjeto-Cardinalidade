package com.senai.projeto.service;

import com.senai.projeto.dto.TarefaRequisicao;
import com.senai.projeto.dto.TarefaResposta;
import com.senai.projeto.mapper.TarefaMapper;
import com.senai.projeto.model.Projeto;
import com.senai.projeto.model.Tarefa;
import com.senai.projeto.repository.ProjetoRepository;
import com.senai.projeto.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final ProjetoRepository projetoRepository;
    private final TarefaMapper mapper;

    public TarefaService(TarefaRepository repository, ProjetoRepository projetoRepository, TarefaMapper mapper) {
        this.repository = repository;
        this.projetoRepository = projetoRepository;
        this.mapper = mapper;
    }

    public TarefaResposta cadastrarTarefa (TarefaRequisicao requisicao) {
        Tarefa tarefa = mapper.paraEntidade(requisicao);
        Projeto projeto = projetoRepository.findById(requisicao.idProjeto())
                .orElseThrow(() -> new RuntimeException ("Projeto não existe!"));

        tarefa.setProjeto(projeto);
        Tarefa salvar = repository.save(tarefa);

        return mapper.paraResposta(salvar);
    }

    public List<TarefaResposta> listarTarefas () {
        List<Tarefa> tarefas = repository.findAll();
        List<TarefaResposta> tarefasRespostas = new ArrayList<>();

        for (Tarefa tarefa : tarefas){
            tarefasRespostas.add(mapper.paraResposta(tarefa));
        }

        return tarefasRespostas;
    }

    // Filtros
    public List<TarefaResposta> buscarPorIdTitulo (Long idProjeto, String titulo) {
        List<Tarefa> tarefa = repository.findByProjetoIdAndTitulo(idProjeto, titulo);
        return mapper.listar(tarefa);
    }

    public List<TarefaResposta> buscarPorTitulo (String titulo) {
        List<Tarefa> tarefa = repository.findByTitulo(titulo);
        return mapper.listar(tarefa);
    }




}
