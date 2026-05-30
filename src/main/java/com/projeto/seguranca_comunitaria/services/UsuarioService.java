package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.repositories.MoradorRepository;
import com.projeto.seguranca_comunitaria.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MoradorRepository moradorRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          MoradorRepository moradorRepository) {
        this.usuarioRepository = usuarioRepository;
        this.moradorRepository = moradorRepository;
    }

    @Transactional
    public Usuario cadastrar(Morador morador, Usuario usuario) {
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new RuntimeException("Login já cadastrado");
        }
        if (moradorRepository.findByCpf(morador.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        Morador moradorSalvo = moradorRepository.save(morador);
        usuario.setMorador(moradorSalvo);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public boolean isVinculado(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(u -> u.getMorador() != null)
                .orElse(false);
    }
}