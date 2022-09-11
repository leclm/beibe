/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.dao.CategoriaProdutoDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CategoriaProdutoFacade {
    public static List<CategoriaProduto> BuscarTudo() {
        return CategoriaProdutoDAO.buscarTudo();
    }
    
    public static void AdicionarCategoriaProduto(CategoriaProduto p) {
        CategoriaProdutoDAO.AdicionarCategoriaProduto(p);
    }

    public static void AlterarCategoriaProduto(CategoriaProduto p) {
        CategoriaProdutoDAO.AlterarCategoriaProduto(p);
    }

    public static void RemoverCategoriaProduto(int id) {
        CategoriaProdutoDAO.RemoverCategoriaProduto(id);
    }
    
    public static CategoriaProduto buscarCategoriaPorId(int id) {
        return CategoriaProdutoDAO.buscarCategoriaPorId(id);
    }
}
