package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Comunidade;
import com.projeto.seguranca_comunitaria.repositories.ComunidadeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComunidadeService {

    private final ComunidadeRepository comunidadeRepository;

    public ComunidadeService(ComunidadeRepository comunidadeRepository) {
        this.comunidadeRepository = comunidadeRepository;
    }

    public Comunidade salvar(Comunidade comunidade) {
        if (comunidade.getCnpj() != null &&
                comunidadeRepository.findByCnpj(comunidade.getCnpj()).isPresent()) {
            throw new RuntimeException("CNPJ já cadastrado");
        }
        return comunidadeRepository.save(comunidade);
    }

    public Optional<Comunidade> buscarPorId(Integer id) {
        return comunidadeRepository.findById(id);
    }

    public List<Comunidade> listarTodos() {
        return comunidadeRepository.findAll();
    }

    public Comunidade atualizar(Comunidade comunidade) {
        return comunidadeRepository.save(comunidade);
    }
}