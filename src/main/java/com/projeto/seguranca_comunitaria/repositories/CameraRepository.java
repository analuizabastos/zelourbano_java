package com.projeto.seguranca_comunitaria.repositories;
import com.projeto.seguranca_comunitaria.entities.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CameraRepository extends JpaRepository<Camera, Integer> {
    List<Camera> findByComunidadeIdComunidade(Integer idComunidade);
}