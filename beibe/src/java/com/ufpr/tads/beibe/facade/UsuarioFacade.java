/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.dao.UsuarioDAO;

/**
 *
 * @author grupo2
 */
public class UsuarioFacade {
    
     public static void adicionarCliente(Usuario c) {
        UsuarioDAO.adicionarCliente(c);
    }

    public static Usuario login(String email, String senha) {
         return UsuarioDAO.login(email,senha);
    }
    
    public static Usuario buscaPorID(int id) {
         return UsuarioDAO.buscaPorId(id);
    }

    public static void aterarUsuario(Usuario u) {
        UsuarioDAO.alterarUsuario(u);
    }
     
}
