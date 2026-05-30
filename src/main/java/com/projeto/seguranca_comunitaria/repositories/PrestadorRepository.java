package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface PrestadorRepository extends JpaRepository<Prestador, Integer> {
    Optional<Prestador> findByCpf(String cpf);
    List<Prestador> findByCategoriaDeServico(String categoria);
}