package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.MoradorUnidade;
import com.projeto.seguranca_comunitaria.entities.MoradorUnidadeId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoradorUnidadeRepository extends JpaRepository<MoradorUnidade, MoradorUnidadeId> {
    List<MoradorUnidade> findByMoradorIdMorador(Integer idMorador);
    List<MoradorUnidade> findByUnidadeIdUnidade(Integer idUnidade);
    boolean existsByMoradorIdMorador(Integer idMorador);
}