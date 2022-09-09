/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
import com.ufpr.tads.beibe.dao.CategoriaAtendimentoDAO;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CategoriaAtendimentoFacade {
    
    public static List<CategoriaAtendimento> buscarCategoriaAtendimento() {
        return CategoriaAtendimentoDAO.buscarTudo();
        
    }
    
    
}
