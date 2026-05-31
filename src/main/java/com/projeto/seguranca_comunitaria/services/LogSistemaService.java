package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.LogSistema;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.repositories.LogSistemaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogSistemaService {

    private final LogSistemaRepository logSistemaRepository;

    public LogSistemaService(LogSistemaRepository logSistemaRepository) {
        this.logSistemaRepository = logSistemaRepository;
    }

    public void registrar(Usuario usuario, String operacao) {
        LogSistema log = new LogSistema();
        log.setUsuario(usuario);
        log.setOperacao(operacao);
        log.setDataHora(LocalDateTime.now());
        logSistemaRepository.save(log);
    }

    // LogSistemaService
    public List<LogSistema> listarPorUsuario(Integer id) {
        return logSistemaRepository.findByUsuario_Id(id);
    }
}