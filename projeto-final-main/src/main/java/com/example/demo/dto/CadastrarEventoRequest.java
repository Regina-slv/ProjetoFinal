package com.example.demo.dto;

import com.example.demo.model.Evento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastrarEventoRequest {

    @NotBlank
    private String categoria;
    @NotBlank
    private String nome;
    @NotBlank
    private String localData;
    @NotNull
    private Float valorIngresso;
    @NotNull
    private Long qtdIngressos;
    public Evento toEvento() {
        return new Evento(this.categoria, this.nome, this.localData, this.valorIngresso, this.qtdIngressos);
    }

    public CadastrarEventoRequest(String categoria, String nome, String localData, Float valorIngresso, Long qtdIngressos) {
        this.categoria = categoria;
        this.nome = nome;
        this.localData = localData;
        this.valorIngresso = valorIngresso;
        this.qtdIngressos = qtdIngressos;
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

    public CadastrarEventoRequest() {
    }
}
