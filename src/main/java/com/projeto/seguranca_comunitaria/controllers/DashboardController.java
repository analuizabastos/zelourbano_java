package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.services.MoradorService;
import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class DashboardController {

    private final UsuarioService usuarioService;
    private final MoradorService moradorService;

    private final PasswordEncoder passwordEncoder;

    public DashboardController(UsuarioService usuarioService, MoradorService moradorService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.moradorService = moradorService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/dashboard-admin")
    public String dashboard() {
        return "dashboard-admin";
    }

    @GetMapping("/gestao-ocorrencias")
    public String gestaoOcorrencias() {
        return "gestao-de-ocorrencias";
    }

    @GetMapping("/cameras")
    public String cameras() {
        return "gestao-de-cameras";
    }

    @GetMapping("/configuracoes")
    public String configuracoes() {
        return "configuracoes";
    }

    @GetMapping("/gestao-usuario")
    public String gestaoUsuario(Model model, Principal principal) {
        String loginLogado = principal.getName();
        Usuario usuarioLogado = usuarioService.buscarPorLogin(loginLogado).orElse(null);
        Morador moradorLogado = usuarioLogado.getMorador();
        model.addAttribute("morador", moradorLogado);
        return "gestao-de-usuario";
    }

    @PostMapping("/gestao-usuario/salvar")
    public String salvarPerfil(@ModelAttribute Morador moradorPreenchido, Principal principal) {
        String loginLogado = principal.getName();
        Usuario usuarioLogado = usuarioService.buscarPorLogin(loginLogado).orElse(null);

        if (usuarioLogado != null) {
            Morador moradorDoBanco = usuarioLogado.getMorador();

            if (moradorPreenchido.getNome() != null && !moradorPreenchido.getNome().trim().isEmpty()) {
                moradorDoBanco.setNome(moradorPreenchido.getNome());
            }
            if (moradorPreenchido.getTelefone() != null && !moradorPreenchido.getTelefone().trim().isEmpty()) {
                moradorDoBanco.setTelefone(moradorPreenchido.getTelefone());
            }
            if (moradorPreenchido.getEmail() != null && !moradorPreenchido.getEmail().trim().isEmpty()) {
                moradorDoBanco.setEmail(moradorPreenchido.getEmail());
            }
            if (moradorPreenchido.getCep() != null && !moradorPreenchido.getCep().trim().isEmpty()) {
                moradorDoBanco.setCep(moradorPreenchido.getCep());
            }
            if (moradorPreenchido.getLogradouro() != null && !moradorPreenchido.getLogradouro().trim().isEmpty()) {
                moradorDoBanco.setLogradouro(moradorPreenchido.getLogradouro());
            }
            if (moradorPreenchido.getNumero() != null && !moradorPreenchido.getNumero().trim().isEmpty()) {
                moradorDoBanco.setNumero(moradorPreenchido.getNumero());
            }
            if (moradorPreenchido.getComplemento() != null) {
                moradorDoBanco.setComplemento(moradorPreenchido.getComplemento());
            }
            if (moradorPreenchido.getCidade() != null && !moradorPreenchido.getCidade().trim().isEmpty()) {
                moradorDoBanco.setCidade(moradorPreenchido.getCidade());
            }
            if (moradorPreenchido.getEstado() != null && !moradorPreenchido.getEstado().trim().isEmpty()) {
                moradorDoBanco.setEstado(moradorPreenchido.getEstado());
            }
            usuarioService.atualizar(moradorDoBanco, usuarioLogado);
        }
        return "redirect:/gestao-usuario";
    }

    @PostMapping("/gestao-usuario/alterar-senha")
    public String alterarSenha(@RequestParam("novaSenha") String novaSenha,
                               @RequestParam("confirmarSenha") String confirmarSenha,
                               Principal principal) {
        if (!novaSenha.equals(confirmarSenha) || novaSenha.trim().isEmpty()) {
            return "redirect:/gestao-usuario?erroSenha=true";
        }
        String loginLogado = principal.getName();
        Usuario usuarioLogado = usuarioService.buscarPorLogin(loginLogado).orElse(null);
        if (usuarioLogado != null) {
            Morador moradorBanco = usuarioLogado.getMorador();
            usuarioLogado.setSenha(passwordEncoder.encode(novaSenha));
            usuarioService.atualizar(moradorBanco, usuarioLogado);
        }
        return "redirect:/gestao-usuario?sucessoSenha=true";
    }


}