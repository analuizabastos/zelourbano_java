package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Ocorrencia;
import com.projeto.seguranca_comunitaria.services.OcorrenciaService;
import com.projeto.seguranca_comunitaria.services.TipoOcorrenciaService;
import com.projeto.seguranca_comunitaria.services.StatusSistemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;
    private final TipoOcorrenciaService tipoOcorrenciaService;
    private final StatusSistemaService statusSistemaService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService,
                                TipoOcorrenciaService tipoOcorrenciaService,
                                StatusSistemaService statusSistemaService) {
        this.ocorrenciaService = ocorrenciaService;
        this.tipoOcorrenciaService = tipoOcorrenciaService;
        this.statusSistemaService = statusSistemaService;
    }

    @GetMapping("/geral")
    public String feedGeral(Model model) {
        model.addAttribute("ocorrencias",
                ocorrenciaService.listarPorComunidade(1));
        return "home-morador-geral";
    }

    @GetMapping("/minhas")
    public String feedMinhas(Model model) {
        model.addAttribute("ocorrencias",
                ocorrenciaService.listarPorUsuario(1));
        return "home-morador-minhas-ocorrencias";
    }

    @GetMapping("/nova")
    public String formulario(Model model) {
        model.addAttribute("ocorrencia", new Ocorrencia());
        model.addAttribute("tipos", tipoOcorrenciaService.listarTodos());
        return "registro-de-ocorrencias";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Ocorrencia ocorrencia) {
        ocorrenciaService.registrar(ocorrencia);
        return "redirect:/ocorrencias/geral";
    }
}