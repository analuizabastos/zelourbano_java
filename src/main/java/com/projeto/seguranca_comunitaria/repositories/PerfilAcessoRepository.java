package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.PerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilAcessoRepository extends JpaRepository<PerfilAcesso, Integer> {

    Optional<PerfilAcesso> findByNome(String nome);
}