package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Prestador;
import com.projeto.seguranca_comunitaria.services.PrestadorService;
import com.projeto.seguranca_comunitaria.services.StatusSistemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prestadores")
public class PrestadorController {

    private final PrestadorService prestadorService;
    private final StatusSistemaService statusSistemaService;

    public PrestadorController(PrestadorService prestadorService,
                               StatusSistemaService statusSistemaService) {
        this.prestadorService = prestadorService;
        this.statusSistemaService = statusSistemaService;
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("prestador", new Prestador());
        model.addAttribute("statuses", statusSistemaService.listarTodos());
        return "cadastro-de-prestador";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Prestador prestador) {
        prestadorService.salvar(prestador);
        return "redirect:/dashboard-admin";
    }
}