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
public class CategoriaAtendimento implements Serializable {
    private int id;
    private String nome;
    private int totalAtendimentos;
    private int atendimentosAbertos;

    public CategoriaAtendimento() {
    }

    public CategoriaAtendimento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public CategoriaAtendimento(int id, String nome, int totalAtendimentos, int atendimentosAbertos) {
        this.id = id;
        this.nome = nome;
        this.totalAtendimentos = totalAtendimentos;
        this.atendimentosAbertos = atendimentosAbertos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getTotalAtendimentos() {
        return totalAtendimentos;
    }
    
    public void setTotalAtendimentos(int totalAtendimentos) {
        this.totalAtendimentos = totalAtendimentos;
    }

    public int getAtendimentosAbertos() {
        return atendimentosAbertos;
    }

    public void setAtendimentosAbertos(int atendimentosAbertos) {
        this.atendimentosAbertos = atendimentosAbertos;
    }
    
}
