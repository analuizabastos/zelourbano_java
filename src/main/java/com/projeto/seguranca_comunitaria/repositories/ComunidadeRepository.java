package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Comunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
public interface ComunidadeRepository extends JpaRepository<Comunidade, Integer> {
    Optional<Comunidade> findByCnpj(String cnpj);
    List<Comunidade> findByNomeContaining(String nome);
}