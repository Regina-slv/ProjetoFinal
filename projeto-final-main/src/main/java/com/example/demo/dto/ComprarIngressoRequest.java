package com.example.demo.dto;

import com.example.demo.model.Evento;
import com.example.demo.model.Ingresso;

import javax.validation.constraints.NotBlank;

public class ComprarIngressoRequest {
    private String nomeCliente;

    private String cpfCliente;
    private String emailCliente;
    private Long idEvento;

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public ComprarIngressoRequest() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Ingresso toIngresso(Evento evento){
        return new Ingresso(
                this.nomeCliente,
                this.cpfCliente,
                this.emailCliente,
                evento
        );
    }

    public ComprarIngressoRequest(String nomeCliente, String cpfCliente, String emailCliente, Long idEvento) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.idEvento = idEvento;
    }
}
