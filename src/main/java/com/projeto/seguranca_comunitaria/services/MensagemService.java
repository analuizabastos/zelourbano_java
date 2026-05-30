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

    public List<Mensagem> listarPorOcorrencia(Integer idOcorrencia) {
        return mensagemRepository
                .findByOcorrenciaIdOcorrencia(idOcorrencia);
    }
}