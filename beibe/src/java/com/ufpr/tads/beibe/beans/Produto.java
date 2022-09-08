/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.beans;

import java.io.Serializable;

/**
 *
 * @author grupo2
 */
public class Produto implements Serializable{
    private int id;
    private CategoriaProduto idCategoriaProduto;
    private String nome;
    private String descricao;
    private int peso;
    
    public Produto() {}

    public Produto(int id, CategoriaProduto idCategoriaProduto, String nome, String descricao, int peso) {
        this.id = id;
        this.idCategoriaProduto = idCategoriaProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoriaProduto getIdCategoriaProduto() {
        return idCategoriaProduto;
    }

    public void setIdCategoriaProduto(CategoriaProduto idCategoriaProduto) {
        this.idCategoriaProduto = idCategoriaProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

   
    
}
