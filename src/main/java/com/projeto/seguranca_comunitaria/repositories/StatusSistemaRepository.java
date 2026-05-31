package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusSistemaRepository extends JpaRepository<StatusSistema, Integer> {

    Optional<StatusSistema> findByNome(String nome);
}