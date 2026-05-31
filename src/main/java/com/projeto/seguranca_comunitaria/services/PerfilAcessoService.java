package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.PerfilAcesso;
import com.projeto.seguranca_comunitaria.repositories.PerfilAcessoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfilAcessoService {

    private final PerfilAcessoRepository repository;

    public PerfilAcessoService(PerfilAcessoRepository repository) {
        this.repository = repository;
    }

    public List<PerfilAcesso> listarTodos() {
        return repository.findAll();
    }
}