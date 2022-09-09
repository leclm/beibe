/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.dao.ProdutoDAO;
import java.util.List;



/**
 *
 * @author grupo2
 */
public class ProdutoFacade {
    public static List<Produto> buscarProdutos() {
        return ProdutoDAO.buscarTudo();
    }
    
}
