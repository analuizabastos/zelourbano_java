package com.projeto.seguranca_comunitaria.controllers;

import com.projeto.seguranca_comunitaria.entities.Morador;
import com.projeto.seguranca_comunitaria.entities.Usuario;
import com.projeto.seguranca_comunitaria.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro")
public class MoradorController {

    private final MoradorService moradorService;
    private final UsuarioService usuarioService;
    private final StatusSistemaService statusSistemaService;
    private final PerfilAcessoService perfilAcessoService;
    private final ComunidadeService comunidadeService;

    public MoradorController(MoradorService moradorService,
                             UsuarioService usuarioService,
                             StatusSistemaService statusSistemaService,
                             PerfilAcessoService perfilAcessoService,
                             ComunidadeService comunidadeService) {
        this.moradorService = moradorService;
        this.usuarioService = usuarioService;
        this.statusSistemaService = statusSistemaService;
        this.perfilAcessoService = perfilAcessoService;
        this.comunidadeService = comunidadeService;
    }

    @GetMapping
    public String formulario(Model model) {
        model.addAttribute("morador", new Morador());
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("statuses", statusSistemaService.listarTodos());
        model.addAttribute("perfis", perfilAcessoService.listarTodos());
        model.addAttribute("comunidades", comunidadeService.listarTodos());
        return "cadastro-de-usuario";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Morador morador,
            @RequestParam String senha,
            @RequestParam(required = false) String perfilAcesso,
            @RequestParam(required = false) String comunidadeId) {

        Usuario usuario = new Usuario();
        usuario.setSenha(senha);
        usuarioService.cadastrar(morador, usuario);
        return "redirect:/login";
    }

}