package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Mensagem;
import com.projeto.seguranca_comunitaria.repositories.MensagemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem salvar(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    // MensagemService
    public List<Mensagem> listarPorOcorrencia(Integer id) {
        return mensagemRepository.findByOcorrencia_Id(id);
    }

}