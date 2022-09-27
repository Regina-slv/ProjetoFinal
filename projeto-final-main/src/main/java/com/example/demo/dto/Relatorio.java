package com.example.demo.dto;

import com.example.demo.model.Evento;

public class Relatorio {
  private String nomeShow;
    private Float valorIngresso;
    private Long qtdIngressosDisponiveis;
    private int qtdIngressosVendidos;
    private Float totalArrecadado;

    public Relatorio(String nomeShow, Float valorIngresso, Long qtdIngressosDisponiveis, int qtdIngressosVendidos, Float totalArrecadado) {
        this.nomeShow = nomeShow;
        this.valorIngresso = valorIngresso;
        this.qtdIngressosDisponiveis = qtdIngressosDisponiveis;
        this.qtdIngressosVendidos = qtdIngressosVendidos;
        this.totalArrecadado = totalArrecadado;
    }
    public Relatorio(Evento evento) {
        int vendidos = evento.getIngressos().size();
        this.nomeShow = evento.getNome();
        this.valorIngresso = evento.getValorIngresso();
        this.qtdIngressosDisponiveis = evento.getQtdIngressos();
        this.qtdIngressosVendidos = vendidos;
        this.totalArrecadado = evento.getValorIngresso() * vendidos;
    }

    public String getNomeShow() {
        return nomeShow;
    }

    public void setNomeShow(String nomeShow) {
        this.nomeShow = nomeShow;
    }

    public Float getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(Float valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public Long getQtdIngressosDisponiveis() {
        return qtdIngressosDisponiveis;
    }

    public void setQtdIngressosDisponiveis(Long qtdIngressosDisponiveis) {
        this.qtdIngressosDisponiveis = qtdIngressosDisponiveis;
    }

    public int getQtdIngressosVendidos() {
        return qtdIngressosVendidos;
    }

    public void setQtdIngressosVendidos(int qtdIngressosVendidos) {
        this.qtdIngressosVendidos = qtdIngressosVendidos;
    }

    public Float getTotalArrecadado() {
        return totalArrecadado;
    }

    public void setTotalArrecadado(Float totalArrecadado) {
        this.totalArrecadado = totalArrecadado;
    }

    public Relatorio() {
    }
}
