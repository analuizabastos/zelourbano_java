package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import com.projeto.seguranca_comunitaria.repositories.StatusSistemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusSistemaService {

    private final StatusSistemaRepository repository;

    public StatusSistemaService(StatusSistemaRepository repository) {
        this.repository = repository;
    }

    public List<StatusSistema> listarTodos() {
        return repository.findAll();
    }

    public StatusSistema buscarPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Status nao encontrado"));
    }
}