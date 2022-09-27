package com.example.demo.dto;

public class DeletarEventoRequest {
    private Long idEvento;

    public DeletarEventoRequest(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public DeletarEventoRequest() {
    }
}
