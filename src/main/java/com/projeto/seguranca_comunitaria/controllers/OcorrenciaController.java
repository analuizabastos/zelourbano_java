package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.*;
import com.projeto.seguranca_comunitaria.services.OcorrenciaService;
import com.projeto.seguranca_comunitaria.services.TipoOcorrenciaService;
import com.projeto.seguranca_comunitaria.services.StatusSistemaService;
import com.projeto.seguranca_comunitaria.services.PrestadorService;
import com.projeto.seguranca_comunitaria.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;
    private final TipoOcorrenciaService tipoOcorrenciaService;
    private final StatusSistemaService statusSistemaService;
    private final UsuarioService usuarioService;
    private final PrestadorService prestadorService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService,
                                TipoOcorrenciaService tipoOcorrenciaService,
                                StatusSistemaService statusSistemaService, UsuarioService usuarioService, PrestadorService prestadorService) {
        this.ocorrenciaService = ocorrenciaService;
        this.tipoOcorrenciaService = tipoOcorrenciaService;
        this.statusSistemaService = statusSistemaService;
        this.usuarioService = usuarioService;
        this.prestadorService = prestadorService;
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
        model.addAttribute("ocorrenciaForm", new Ocorrencia());
        model.addAttribute("tipos", tipoOcorrenciaService.listarTodos());
        model.addAttribute("prestadores", prestadorService.listarTodos());
        return "registro-de-ocorrencias";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Ocorrencia ocorrencia,
            @RequestParam Integer tipoOcorrenciaId,
            @RequestParam(required = false) Integer prestadorId,
            Principal principal) {

        TipoOcorrencia tipo = tipoOcorrenciaService.buscarPorId(tipoOcorrenciaId);
        ocorrencia.setTipoOcorrencia(tipo);

        Usuario autor = usuarioService.buscarPorLogin(principal.getName()).orElseThrow();
        ocorrencia.setUsuarioAutor(autor);

        StatusSistema aberto = statusSistemaService.buscarPorNome("Ativo");
        ocorrencia.setStatus(aberto);

        Comunidade comunidade = new Comunidade();
        comunidade.setId(1);
        ocorrencia.setComunidade(comunidade);

        ocorrencia.setLatitude(new BigDecimal("-9.66599000"));
        ocorrencia.setLongitude(new BigDecimal("-35.73509000"));

        if (ocorrencia.getTitulo() == null || ocorrencia.getTitulo().isEmpty()) {
            ocorrencia.setTitulo("Ocorrência sem título");
        }
        if (ocorrencia.getDescricao() == null || ocorrencia.getDescricao().isEmpty()) {
            ocorrencia.setDescricao("Sem descrição");
        }
        if (ocorrencia.getDenunciaAnonima() == null) {
            ocorrencia.setDenunciaAnonima(false);
        }
        if (prestadorId != null) {
            Prestador prestador = new Prestador();
            prestador.setId(prestadorId);
            ocorrencia.setPrestador(prestador);
        }

        ocorrenciaService.registrar(ocorrencia);
        return "redirect:/ocorrencias/geral";
    }
}