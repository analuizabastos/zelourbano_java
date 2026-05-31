package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.TipoOcorrencia;
import com.projeto.seguranca_comunitaria.repositories.TipoOcorrenciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoOcorrenciaService {

    private final TipoOcorrenciaRepository repository;

    public TipoOcorrenciaService(TipoOcorrenciaRepository repository) {
        this.repository = repository;
    }

    public List<TipoOcorrencia> listarTodos() {
        return repository.findAll();
    }
}