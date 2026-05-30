package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Prestador;
import com.projeto.seguranca_comunitaria.repositories.PrestadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrestadorService {

    private final PrestadorRepository prestadorRepository;

    public PrestadorService(PrestadorRepository prestadorRepository) {
        this.prestadorRepository = prestadorRepository;
    }

    public Prestador salvar(Prestador prestador) {
        if (prestador.getCpf() != null &&
                prestadorRepository.findByCpf(prestador.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return prestadorRepository.save(prestador);
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