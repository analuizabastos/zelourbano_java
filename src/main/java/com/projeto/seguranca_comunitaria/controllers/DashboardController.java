package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.services.MoradorService;
import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class DashboardController {

    private final UsuarioService usuarioService;
    private final MoradorService moradorService;

    public DashboardController(UsuarioService usuarioService, MoradorService moradorService) {
        this.usuarioService = usuarioService;
        this.moradorService = moradorService;
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
            moradorDoBanco.setNome(moradorPreenchido.getNome());
            moradorDoBanco.setTelefone(moradorPreenchido.getTelefone());
            moradorDoBanco.setEmail(moradorPreenchido.getEmail());
            moradorDoBanco.setCep(moradorPreenchido.getCep());
            moradorDoBanco.setNumero(moradorPreenchido.getNumero());
            usuarioService.cadastrar(moradorDoBanco, usuarioLogado);
        }

        return "redirect:/gestao-usuario";
    }
}