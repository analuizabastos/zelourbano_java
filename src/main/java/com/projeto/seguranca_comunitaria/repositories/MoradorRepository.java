package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    Optional<Morador> findByCpf(String cpf);
    Optional<Morador> findByEmail(String email);
}