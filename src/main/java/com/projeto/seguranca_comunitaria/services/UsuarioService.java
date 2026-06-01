package com.projeto.seguranca_comunitaria.services;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.PerfilAcesso;
import com.projeto.seguranca_comunitaria.entities.StatusSistema;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.repositories.MoradorRepository;
import com.projeto.seguranca_comunitaria.repositories.UsuarioRepository;
import com.projeto.seguranca_comunitaria.repositories.StatusSistemaRepository;
import com.projeto.seguranca_comunitaria.repositories.PerfilAcessoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MoradorRepository moradorRepository;
    private final StatusSistemaRepository statusSistemaRepository;
    private final PerfilAcessoRepository perfilAcessoRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          MoradorRepository moradorRepository,
                          StatusSistemaRepository statusSistemaRepository,
                          PerfilAcessoRepository perfilAcessoRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.moradorRepository = moradorRepository;
        this.statusSistemaRepository = statusSistemaRepository;
        this.perfilAcessoRepository = perfilAcessoRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public Usuario cadastrar(Morador morador, Usuario usuario) {
        if (usuarioRepository.existsByLogin(morador.getEmail())) {
            throw new RuntimeException("Email ja cadastrado");
        }

        StatusSistema aguardando = statusSistemaRepository
                .findByNome("Aguardando")
                .orElseThrow(() -> new RuntimeException("Status Aguardando nao encontrado"));

        PerfilAcesso perfilMorador = perfilAcessoRepository
                .findByNome("Morador")
                .orElseThrow(() -> new RuntimeException("Perfil Morador nao encontrado"));

        morador.setStatus(aguardando);
        usuario.setStatus(aguardando);
        usuario.setLogin(morador.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setPerfilAcesso(perfilMorador);

        Morador moradorSalvo = moradorRepository.save(morador);
        usuario.setMorador(moradorSalvo);
        return usuarioRepository.save(usuario);
    }

    public void desativar(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        StatusSistema inativo = statusSistemaRepository
                .findByNome("Inativo")
                .orElseThrow(() -> new RuntimeException("Status Inativo nao encontrado"));
        usuario.setStatus(inativo);
        usuarioRepository.save(usuario);
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