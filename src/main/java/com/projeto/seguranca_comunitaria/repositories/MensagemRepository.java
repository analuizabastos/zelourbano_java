package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
    List<Mensagem> findByOcorrencia_Id(Integer id);
}