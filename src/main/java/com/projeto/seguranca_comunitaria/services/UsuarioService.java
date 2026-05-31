package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.repositories.MoradorRepository;
import com.projeto.seguranca_comunitaria.repositories.UsuarioRepository;
import com.projeto.seguranca_comunitaria.repositories.StatusSistemaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MoradorRepository moradorRepository;

    private final StatusSistemaRepository statusSistemaRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          MoradorRepository moradorRepository,
                          StatusSistemaRepository statusSistemaRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.moradorRepository = moradorRepository;
        this.statusSistemaRepository = statusSistemaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public Usuario cadastrar(Morador morador, Usuario usuario) {
        // busca o status "Aguardando" automaticamente
        StatusSistema aguardando = statusSistemaRepository
                .findByNome("Aguardando")
                .orElseThrow(() -> new RuntimeException("Status Aguardando nao encontrado"));

        morador.setStatus(aguardando);
        usuario.setStatus(aguardando);

        Morador moradorSalvo = moradorRepository.save(morador);
        usuario.setMorador(moradorSalvo);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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