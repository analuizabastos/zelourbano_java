package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.MoradorUnidade;
import com.projeto.seguranca_comunitaria.entities.MoradorUnidadeId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MoradorUnidadeRepository extends JpaRepository<MoradorUnidade, MoradorUnidadeId> {
    List<MoradorUnidade> findByMorador_Id(Integer id);
    List<MoradorUnidade> findByUnidade_Id(Integer id);
    boolean existsByMorador_Id(Integer id);
}