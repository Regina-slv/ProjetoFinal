package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Evento;
import com.example.demo.service.EventoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventosController {

    private final EventoService eventoService;

    public EventosController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/login")
    public String login(Login login) {
        System.out.println(login);
        if (login.getUsuario().equals("Principal") && login.getSenha().equals("1234")) {
            return "redirect:/listar/eventos";
        } else {
            return "redirect:/lista-eventos/usuario";
        }

    }

    @GetMapping("/form/cadastrar")
    public ModelAndView formCadastrarEvento() {
        return new ModelAndView("formcadastrar");
    }
    @GetMapping("/form/cadastrar/usuario")
    public ModelAndView formCadastrarUsuario() {
        return new ModelAndView("formcadastrarusuario");
    }

    @GetMapping("/form/comprar-ingresso/{idEvento}")
    public ModelAndView formComprarIngresso(@PathVariable("idEvento") Long idEvento) {
        ModelAndView mv = new ModelAndView("formcomprar");
        mv.addObject("idEvento", idEvento);
        return mv;
    }
    @GetMapping("/form/comprar-ingresso/usuario/{idEvento}")
    public ModelAndView formComprarIngressoUsuario(@PathVariable("idEvento") Long idEvento) {
        ModelAndView mv = new ModelAndView("formcomprarusuario");
        mv.addObject("idEvento", idEvento);
        return mv;
    }

    @GetMapping("/form/atualizar-evento/{idEvento}")
    public ModelAndView formAtualizarEvento(@PathVariable("idEvento") Long idEvento) {
        ModelAndView mv = new ModelAndView("formatualizar");
        Evento evento = eventoService.findById(idEvento);
        mv.addObject("evento", evento);
        return mv;
    }

    @GetMapping("/form/deletar-evento/{idEvento}")
    public ModelAndView formDeletarEvento(@PathVariable("idEvento") Long idEvento) {
        ModelAndView mv = new ModelAndView("formdeletar");
        Evento evento = eventoService.findById(idEvento);
        mv.addObject("evento", evento);
        return mv;
    }

    @GetMapping("/listar/eventos")
    public ModelAndView listarEventos() {
        List<Evento> eventos = eventoService.findAll();
        ModelAndView mv = new ModelAndView("listaeventos");
        mv.addObject("eventos", eventos);
        return mv;
    }

    @GetMapping("/lista-eventos/usuario")
    public ModelAndView listarEventosUsusario() {
        List<Evento> eventos = eventoService.findAll();
        ModelAndView mv = new ModelAndView("listaeventosusuario");
        mv.addObject("eventos", eventos);
        return mv;
    }

    @GetMapping("/relatorio")
    public ModelAndView relatorio() {
        List<Relatorio> relatorios = eventoService.relatorio();
        ModelAndView mv = new ModelAndView("relatorio");
        mv.addObject("relatorios", relatorios);
        return mv;
    }

    @GetMapping("/pagamento-confirmado")
    public ModelAndView pagamentoConfirmado() {
        return new ModelAndView("confirmacaopgm");
    }
    @GetMapping("/pagamento-confirmado/usuario")
    public ModelAndView pagamentoConfirmadoUsuario() {
        return new ModelAndView("confirmacaopgmusuario");
    }

    @PostMapping("/cadastrar/evento")
    public String cadastrarEvento(CadastrarEventoRequest request) {
        eventoService.cadastrar(request.toEvento());
        return "redirect:/listar/eventos";
    }
    @PostMapping("/cadastrar/usuario")
    public String cadastrarUsuario() {
        return "redirect:/";
    }

    @PostMapping("/evento/comprar-ingresso")
    public String comprarIngresso(ComprarIngressoRequest request) {
        eventoService.comprarIngresso(request);
        return "redirect:/pagamento-confirmado";
    }
    @PostMapping("/evento/comprar-ingresso/usuario")
    public String comprarIngressoUsuario(ComprarIngressoRequest request) {
        eventoService.comprarIngresso(request);
        return "redirect:/pagamento-confirmado/usuario";
    }

    @PostMapping("/evento/atualizar-evento")
    public String atualizarEvento(AtualizarEventoRequest request) {
        eventoService.atualizarEvento(request.toEvento());
        return "redirect:/listar/eventos";
    }

    @PostMapping("/deletar/evento")
    public String deletarEvento(DeletarEventoRequest request) {
        eventoService.deletar(request.getIdEvento());
        return "redirect:/listar/eventos";
    }
}
