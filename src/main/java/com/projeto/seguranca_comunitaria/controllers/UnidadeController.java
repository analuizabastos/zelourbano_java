package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Unidade;
import com.projeto.seguranca_comunitaria.services.ComunidadeService;
import com.projeto.seguranca_comunitaria.services.StatusSistemaService;
import com.projeto.seguranca_comunitaria.services.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;
    private final ComunidadeService comunidadeService;
    private final StatusSistemaService statusSistemaService;

    public UnidadeController(UnidadeService unidadeService,
                             ComunidadeService comunidadeService,
                             StatusSistemaService statusSistemaService) {
        this.unidadeService = unidadeService;
        this.comunidadeService = comunidadeService;
        this.statusSistemaService = statusSistemaService;
    }

    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("unidade", new Unidade());
        model.addAttribute("comunidades", comunidadeService.listarTodos());
        model.addAttribute("statuses", statusSistemaService.listarTodos());
        return "unidade/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Unidade unidade) {
        unidadeService.salvar(unidade);
        return "redirect:/dashboard-admin";
    }
}