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

    // MoradorUnidadeService
    public boolean isVinculado(Integer idMorador) {
        return moradorUnidadeRepository.existsByMorador_Id(idMorador);
    }
    public List<MoradorUnidade> listarPorMorador(Integer id) {
        return moradorUnidadeRepository.findByMorador_Id(id);
    }
    public List<MoradorUnidade> listarPorUnidade(Integer id) {
        return moradorUnidadeRepository.findByUnidade_Id(id);
    }
}