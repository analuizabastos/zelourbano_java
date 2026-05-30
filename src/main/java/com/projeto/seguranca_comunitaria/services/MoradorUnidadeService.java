package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.MoradorUnidade;
import com.projeto.seguranca_comunitaria.entities.MoradorUnidadeId;
import com.projeto.seguranca_comunitaria.repositories.MoradorUnidadeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MoradorUnidadeService {

    private final MoradorUnidadeRepository moradorUnidadeRepository;

    public MoradorUnidadeService(MoradorUnidadeRepository moradorUnidadeRepository) {
        this.moradorUnidadeRepository = moradorUnidadeRepository;
    }

    public MoradorUnidade vincular(MoradorUnidade moradorUnidade) {
        return moradorUnidadeRepository.save(moradorUnidade);
    }

    public boolean isVinculado(Integer idMorador) {
        return moradorUnidadeRepository.existsByMoradorIdMorador(idMorador);
    }

    public List<MoradorUnidade> listarPorMorador(Integer idMorador) {
        return moradorUnidadeRepository.findByMoradorIdMorador(idMorador);
    }
}