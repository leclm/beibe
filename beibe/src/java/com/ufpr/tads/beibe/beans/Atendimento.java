/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.beans;

import com.sun.xml.ws.security.opt.impl.tokens.Timestamp;
import java.io.Serializable;

/**
 *
 * @author grupo2
 */
public class Atendimento implements Serializable{
    private int id;
    private Timestamp dataHr;
    private Usuario idCliente;
    private SituacaoAtendimento IdSituacaoAtendimento;
    private Produto idProduto;
    private CategoriaAtendimento idCategoriaAtendimento;
    private String descricao;
    private String solucao;

    public Atendimento() {
    }

    public Atendimento(int id, Timestamp dataHr, Usuario idCliente, SituacaoAtendimento IdSituacaoAtendimento, Produto idProduto, CategoriaAtendimento idCategoriaAtendimento, String descricao, String solucao) {
        this.id = id;
        this.dataHr = dataHr;
        this.idCliente = idCliente;
        this.IdSituacaoAtendimento = IdSituacaoAtendimento;
        this.idProduto = idProduto;
        this.idCategoriaAtendimento = idCategoriaAtendimento;
        this.descricao = descricao;
        this.solucao = solucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataHr() {
        return dataHr;
    }

    public void setDataHr(Timestamp dataHr) {
        this.dataHr = dataHr;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    public SituacaoAtendimento getIdSituacaoAtendimento() {
        return IdSituacaoAtendimento;
    }

    public void setIdSituacaoAtendimento(SituacaoAtendimento IdSituacaoAtendimento) {
        this.IdSituacaoAtendimento = IdSituacaoAtendimento;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public CategoriaAtendimento getIdCategoriaAtendimento() {
        return idCategoriaAtendimento;
    }

    public void setIdCategoriaAtendimento(CategoriaAtendimento idCategoriaAtendimento) {
        this.idCategoriaAtendimento = idCategoriaAtendimento;
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
