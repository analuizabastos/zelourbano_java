package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {
    Optional<Ocorrencia> findByProtocolo(String protocolo);
    List<Ocorrencia> findByComunidadeIdComunidade(Integer idComunidade);
    List<Ocorrencia> findByUsuarioAutorIdUsuario(Integer idUsuario);
    long countByProtocoloStartingWith(String prefixo);

}
