/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.dao.AtendimentoDAO;
import java.util.List;

/**
 *
 * @author grupo2
 */

public class AtendimentoFacade {
     public static void adicionarAtendimento(Atendimento a) {
        AtendimentoDAO.adicionarAtendimento(a);
    }
     
     public static List<Atendimento> buscarAtendimentoPorCliente(int id) {
         return AtendimentoDAO.buscarTudoCliente(id);
    }
     
     public static List<Atendimento> buscarAtendimentoPorIdAtendimento(int idu, int ida) {
         return AtendimentoDAO.buscarTudoIdAtendimento(idu, ida);
    }
     
    public static void removerAtendimento(int id) {
        AtendimentoDAO.removerAtendimento(id);
    }
   
}
