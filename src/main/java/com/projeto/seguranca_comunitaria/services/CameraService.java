package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Camera;
import com.projeto.seguranca_comunitaria.repositories.CameraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    private final CameraRepository cameraRepository;

    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera salvar(Camera camera) {
        return cameraRepository.save(camera);
    }

    public Optional<Camera> buscarPorId(Integer id) {
        return cameraRepository.findById(id);
    }

    public List<Camera> listarPorComunidade(Integer idComunidade) {
        return cameraRepository
                .findByComunidadeIdComunidade(idComunidade);
    }

    public Camera atualizar(Camera camera) {
        return cameraRepository.save(camera);
    }
}