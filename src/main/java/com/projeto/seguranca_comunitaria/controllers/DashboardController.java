package com.projeto.seguranca_comunitaria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard-admin")
    public String dashboard() {
        return "dashboard-admin";
    }

    @GetMapping("/gestao-ocorrencias")
    public String gestaoOcorrencias() {
        return "gestao-de-ocorrencias";
    }

    @GetMapping("/gestao-cameras")
    public String gestaoCameras() {
        return "gestao-de-cameras";
    }

    @GetMapping("/configuracoes")
    public String configuracoes() {
        return "configuracoes";
    }
}