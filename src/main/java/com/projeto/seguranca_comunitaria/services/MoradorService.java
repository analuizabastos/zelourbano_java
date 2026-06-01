package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import com.projeto.seguranca_comunitaria.repositories.MoradorRepository;
import com.projeto.seguranca_comunitaria.repositories.StatusSistemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    private final MoradorRepository moradorRepository;
    private final StatusSistemaRepository statusSistemaRepository;

    public MoradorService(MoradorRepository moradorRepository, StatusSistemaRepository statusSistemaRepository) {
        this.moradorRepository = moradorRepository;
        this.statusSistemaRepository = statusSistemaRepository;
    }

    public Morador salvar(Morador morador) {
        if (moradorRepository.findByCpf(morador.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return moradorRepository.save(morador);
    }

    public void desativar(Integer idMorador) {
        Morador morador = moradorRepository.findById(idMorador)
                .orElseThrow(() -> new RuntimeException("Morador nao encontrado"));
        StatusSistema inativo = statusSistemaRepository
                .findByNome("Inativo")
                .orElseThrow(() -> new RuntimeException("Status nao encontrado"));
        morador.setStatus(inativo);
        moradorRepository.save(morador);
    }

    public Optional<Morador> buscarPorId(Integer id) {
        return moradorRepository.findById(id);
    }

    public Optional<Morador> buscarPorCpf(String cpf) {
        return moradorRepository.findByCpf(cpf);
    }

    public List<Morador> listarTodos() {
        return moradorRepository.findAll();
    }

    public Morador atualizar(Morador morador) {
        return moradorRepository.save(morador);
    }
}