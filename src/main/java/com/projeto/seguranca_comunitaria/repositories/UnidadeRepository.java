package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {
    List<Unidade> findByComunidade_Id(Integer id);
}