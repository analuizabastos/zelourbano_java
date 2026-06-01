package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Prestador;
import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import com.projeto.seguranca_comunitaria.repositories.PrestadorRepository;
import com.projeto.seguranca_comunitaria.repositories.StatusSistemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrestadorService {

    private final PrestadorRepository prestadorRepository;
    private final StatusSistemaRepository statusSistemaRepository;
    public PrestadorService(PrestadorRepository prestadorRepository, StatusSistemaRepository statusSistemaRepository) {
        this.prestadorRepository = prestadorRepository;
        this.statusSistemaRepository = statusSistemaRepository;
    }

    public Prestador salvar(Prestador prestador) {
        if (prestador.getCpf() != null &&
                prestadorRepository.findByCpf(prestador.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return prestadorRepository.save(prestador);
    }

    public void desativar(Integer idPrestador) {
        Prestador prestador = prestadorRepository.findById(idPrestador)
                .orElseThrow(() -> new RuntimeException("Prestador nao encontrado"));
        StatusSistema inativo = statusSistemaRepository
                .findByNome("Inativo")
                .orElseThrow(() -> new RuntimeException("Status nao encontrado"));
        prestador.setStatus(inativo);
        prestadorRepository.save(prestador);
    }

    public Optional<Prestador> buscarPorId(Integer id) {
        return prestadorRepository.findById(id);
    }

    public List<Prestador> listarTodos() {
        return prestadorRepository.findAll();
    }

    public Prestador atualizar(Prestador prestador) {
        return prestadorRepository.save(prestador);
    }
}