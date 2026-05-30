package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Ocorrencia;
import com.projeto.seguranca_comunitaria.repositories.OcorrenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    private String gerarProtocolo() {
        String hoje = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        long count = ocorrenciaRepository.countByProtocoloStartingWith(hoje);
        return hoje + "-" + String.format("%04d", count + 1);
    }

    @Transactional
    public Ocorrencia registrar(Ocorrencia ocorrencia) {
        ocorrencia.setProtocolo(gerarProtocolo());
        return ocorrenciaRepository.save(ocorrencia);
    }

    @Transactional
    public Ocorrencia criarComunicado(Ocorrencia comunicado) {
        comunicado.setProtocolo(gerarProtocolo());
        comunicado.setDenunciaAnonima(false);
        return ocorrenciaRepository.save(comunicado);
    }

    // OcorrenciaService
    public List<Ocorrencia> listarPorComunidade(Integer id) {
        return ocorrenciaRepository.findByComunidade_Id(id);
    }
    public List<Ocorrencia> listarPorUsuario(Integer id) {
        return ocorrenciaRepository.findByUsuarioAutor_Id(id);
    }

    public Optional<Ocorrencia> buscarPorProtocolo(String protocolo) {
        return ocorrenciaRepository.findByProtocolo(protocolo);
    }

    public Optional<Ocorrencia> buscarPorId(Integer id) {
        return ocorrenciaRepository.findById(id);
    }

    public Ocorrencia atualizar(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
}