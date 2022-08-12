/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.dao.UsuarioDAO;

/**
 *
 * @author nicol
 */
public class UsuarioFacade {
    
     public static void adicionarCliente(Usuario c) {
        UsuarioDAO.adicionarCliente(c);
    }
     
}
