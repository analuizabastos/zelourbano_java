package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Comunidade;
import com.projeto.seguranca_comunitaria.services.ComunidadeService;
import com.projeto.seguranca_comunitaria.services.StatusSistemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comunidades")
public class ComunidadeController {

    private final ComunidadeService comunidadeService;
    private final StatusSistemaService statusSistemaService;

    public ComunidadeController(ComunidadeService comunidadeService,
                                StatusSistemaService statusSistemaService) {
        this.comunidadeService = comunidadeService;
        this.statusSistemaService = statusSistemaService;
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("comunidade", new Comunidade());
        model.addAttribute("statuses", statusSistemaService.listarTodos());
        return "cadastro-de-comunidade";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Comunidade comunidade) {
        comunidadeService.salvar(comunidade);
        return "redirect:/dashboard-admin";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("comunidades", comunidadeService.listarTodos());
        return "comunidade/lista";
    }
}