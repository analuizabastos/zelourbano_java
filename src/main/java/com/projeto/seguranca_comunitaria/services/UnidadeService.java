package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Unidade;
import com.projeto.seguranca_comunitaria.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public Unidade salvar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public Optional<Unidade> buscarPorId(Integer id) {
        return unidadeRepository.findById(id);
    }

    public List<Unidade> listarPorComunidade(Integer idComunidade) {
        return unidadeRepository.findByComunidade_Id(idComunidade);
    }

    public Unidade atualizar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }
}