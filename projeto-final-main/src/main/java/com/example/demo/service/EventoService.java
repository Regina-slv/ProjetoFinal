package com.example.demo.service;

import com.example.demo.dto.ComprarIngressoRequest;
import com.example.demo.dto.Relatorio;
import com.example.demo.model.Evento;
import com.example.demo.model.Ingresso;
import com.example.demo.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void cadastrar(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> findAll() {
        List<Evento> eventos = new ArrayList<>();
        Iterable<Evento> all = eventoRepository.findAll();
        for (Evento evento : all) {
            if (evento.getQtdIngressos() > 0) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public void comprarIngresso(ComprarIngressoRequest request) {

        Evento evento = this.findById(request.getIdEvento());

        Ingresso ingresso = request.toIngresso(evento);
        evento.registraIngresso(ingresso);
        eventoRepository.save(evento);
    }

    public Evento findById(Long idEvento) {
        Optional<Evento> byId = eventoRepository.findById(idEvento);
        if (byId.isEmpty()){
            throw new RuntimeException("Evento invalido");
        }
      return byId.get();
    }

    public void atualizarEvento(Evento evento) {
        eventoRepository.save(evento);

    }

    public void deletar(Long idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    public List<Relatorio> relatorio() {
        List<Evento> eventos = this.findAll();
        List<Relatorio> relatorios=new ArrayList<>();
        for (Evento evento :eventos) {
          relatorios.add(new Relatorio(evento));
        }
        return relatorios;
    }
}
