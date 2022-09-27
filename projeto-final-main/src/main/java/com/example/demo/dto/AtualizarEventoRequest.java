package com.example.demo.dto;

import com.example.demo.model.Evento;

public class AtualizarEventoRequest {
    private Long idEvento;
    private String categoria;

    private String nome;

    private String localData;
    private Float valorIngresso;
    private Long qtdIngressos;

    public AtualizarEventoRequest() {
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalData() {
        return localData;
    }

    public void setLocalData(String localData) {
        this.localData = localData;
    }

    public Float getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(Float valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public Long getQtdIngressos() {
        return qtdIngressos;
    }

    public void setQtdIngressos(Long qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }

    public AtualizarEventoRequest(Long idEvento, String categoria, String nome, String localData, Float valorIngresso, Long qtdIngressos) {
        this.idEvento = idEvento;
        this.categoria = categoria;
        this.nome = nome;
        this.localData = localData;
        this.valorIngresso = valorIngresso;
        this.qtdIngressos = qtdIngressos;
    }


    public Evento toEvento() {
        return new Evento(this.idEvento, this.categoria, this.nome, this.localData, this.valorIngresso, this.qtdIngressos);
    }
}
