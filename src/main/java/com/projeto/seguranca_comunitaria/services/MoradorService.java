package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.repositories.MoradorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    private final MoradorRepository moradorRepository;

    public MoradorService(MoradorRepository moradorRepository) {
        this.moradorRepository = moradorRepository;
    }

    public Morador salvar(Morador morador) {
        if (moradorRepository.findByCpf(morador.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return moradorRepository.save(morador);
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