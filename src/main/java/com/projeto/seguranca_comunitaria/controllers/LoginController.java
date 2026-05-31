package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

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
}