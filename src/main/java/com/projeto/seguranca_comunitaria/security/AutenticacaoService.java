package com.projeto.seguranca_comunitaria.security;

import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario nao encontrado: " + login));

        String role = "MORADOR";
        if (usuario.getPrestador() != null) {
            role = "PRESTADOR";
        }

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(role)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}