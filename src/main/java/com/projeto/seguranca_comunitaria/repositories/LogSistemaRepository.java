package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.LogSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface LogSistemaRepository extends JpaRepository<LogSistema, Integer> {
    List<LogSistema> findByUsuarioIdUsuario(Integer idUsuario);
}