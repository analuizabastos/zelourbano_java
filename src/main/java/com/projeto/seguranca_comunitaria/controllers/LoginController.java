package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.services.ComunidadeService;
import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final ComunidadeService comunidadeService;

    public LoginController(ComunidadeService comunidadeService) {
        this.comunidadeService = comunidadeService;
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

    @GetMapping("/dashboard/residente")
    public String dashboardResidente() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard/prestador")
    public String dashboardPrestador() {
        return "redirect:/login";
    }

    @GetMapping("/login-admin")
    public String loginAdmin(Model model) {
        model.addAttribute("comunidades", comunidadeService.listarTodos());
        return "login-admin";
    }
}