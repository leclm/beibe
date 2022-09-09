/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.dao.CategoriaProdutoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CategoriaProdutoFacade {
    public static List<CategoriaProduto> BuscarTudo() {
        List<CategoriaProduto> listCategoriaProduto = new ArrayList<CategoriaProduto>();
        
        listCategoriaProduto = CategoriaProdutoDAO.buscarTudo();
            
        return listCategoriaProduto;
    }
}
