/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.dao.CategoriaProdutoDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class ProdutoFacade {
    public static void ApresentarCategorias(HttpServletRequest request) {
        if (request.getSession().getAttribute("categorias") == null) {
            try (ConnectionFactory con = new ConnectionFactory()) {
                List<CategoriaProduto> categorias = CategoriaProdutoDAO.buscarTudo();

                request.setAttribute("categorias", categorias);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void AdicionarProduto(Produto p) {
        ProdutoDAO.AdicionarProduto(p);
    }

    public static void AlterarProduto(Produto p) {
        ProdutoDAO.AlterarProduto(p);
    }

    public static List<Produto> buscarProdutos() {
        List<Produto> listProduto = new ArrayList<Produto>();
        
        listProduto = ProdutoDAO.buscarTudo();
            
        return listProduto;
    }

    public static void RemoverProduto(int id) {
        ProdutoDAO.RemoverProduto(id);
    }
    
    public static List<Produto> buscarProdutos() {
        return ProdutoDAO.buscarTudo();
    }
}
