/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.beans;

import com.sun.xml.ws.security.opt.impl.tokens.Timestamp;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author grupo2
 */
public class Atendimento implements Serializable{
    private int id;
    private Date dataHr;
    private String cliente;
    private String situacaoAtendimento;
    private int produto;
    private int categoriaAtendimento;
    private String descricao;
    private String solucao;

    public Atendimento() {
    }

    public Atendimento(int id, Date dataHr, String cliente, String situacaoAtendimento, int produto, int categoriaAtendimento, String descricao, String solucao) {
        this.id = id;
        this.dataHr = dataHr;
        this.cliente = cliente;
        this.situacaoAtendimento = situacaoAtendimento;
        this.produto = produto;
        this.categoriaAtendimento = categoriaAtendimento;
        this.descricao = descricao;
        this.solucao = solucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHr() {
        return dataHr;
    }

    public void setDataHr(Date dataHr) {
        this.dataHr = dataHr;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSituacaoAtendimento() {
        return situacaoAtendimento;
    }

    public void setSituacaoAtendimento(String situacaoAtendimento) {
        this.situacaoAtendimento = situacaoAtendimento;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCategoriaAtendimento() {
        return categoriaAtendimento;
    }

    public void setCategoriaAtendimento(int categoriaAtendimento) {
        this.categoriaAtendimento = categoriaAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

     
    
}
