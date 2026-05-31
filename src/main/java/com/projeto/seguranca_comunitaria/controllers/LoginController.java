package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String landingPage() {
        return "landing-page";
    }

    @GetMapping("/selecao-perfil")
    public String selecaoPerfil() {
        return "selecao-de-perfil";
    }

    @GetMapping("/login")
    public String loginMorador() {
        return "login";
    }

    @GetMapping("/login-admin")
    public String loginAdmin() {
        return "login-admin";
    }

    @PostMapping("/login/entrar")
    public String entrar(@RequestParam String login,
                         @RequestParam String senha,
                         Model model) {
        return usuarioService.buscarPorLogin(login)
                .map(u -> {
                    if (u.getPrestador() != null) {
                        return "redirect:/prestador/chamados";
                    }
                    return "redirect:/ocorrencias/geral";
                })
                .orElseGet(() -> {
                    model.addAttribute("erro", "Login ou senha inválidos");
                    return "login";
                });
    }

    @PostMapping("/login-admin/entrar")
    public String entrarAdmin(@RequestParam String login,
                              @RequestParam String senha,
                              Model model) {
        return usuarioService.buscarPorLogin(login)
                .map(u -> "redirect:/dashboard-admin")
                .orElseGet(() -> {
                    model.addAttribute("erro", "Login ou senha inválidos");
                    return "login-admin";
                });
    }
}