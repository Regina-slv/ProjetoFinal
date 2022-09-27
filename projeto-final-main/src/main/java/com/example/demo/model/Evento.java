package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;

    private String nome;

    public Evento(Long id, String categoria, String nome, String localData, Float valorIngresso, Long qtdIngressos) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.localData = localData;
        this.valorIngresso = valorIngresso;
        this.qtdIngressos = qtdIngressos;
    }

    private String localData;
    private Float valorIngresso;
    private Long qtdIngressos;
    @OneToMany(cascade = CascadeType.MERGE)
    private final List<Ingresso> ingressos = new ArrayList<>();

    public Evento(String categoria, String nome, String localData, Float valorIngresso, Long qtdIngressos) {
        this.categoria = categoria;
        this.nome = nome;
        this.localData = localData;
        this.valorIngresso = valorIngresso;
        this.qtdIngressos = qtdIngressos;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void registraIngresso(Ingresso ingresso) {
        if (this.qtdIngressos<=0){
            throw new RuntimeException("Todos os ingressos já foram vendidos");
        }
        ingressos.add(ingresso);
        qtdIngressos--;
    }


    @Deprecated
    public Evento() {
    }


}
