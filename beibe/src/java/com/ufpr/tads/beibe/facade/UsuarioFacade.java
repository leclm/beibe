/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.dao.UsuarioDAO;
import com.ufpr.tads.beibe.exception.DAOException;
import com.ufpr.tads.beibe.exception.FacadeException;
import java.util.List;
/**
 *
 * @author grupo2
 */
public class UsuarioFacade {
    
     public static void adicionarCliente(Usuario c) throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
         UsuarioDAO dao= new UsuarioDAO(con.getConnection());
         dao.adicionarCliente(c);
         }
         catch (DAOException ex){
           throw new FacadeException("Erro ao adicionar usuario",ex );
       }
    }

    public static Usuario login(String email, String senha)throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
             UsuarioDAO dao= new UsuarioDAO(con.getConnection());
             return dao.login(email,senha);}
         catch (DAOException ex){
         throw new FacadeException("Erro ao fazer login",ex );
       }
    }
    
    public static Usuario buscaPorID(int id)throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
             UsuarioDAO dao= new UsuarioDAO(con.getConnection());
             return dao.buscaPorId(id);
         }
         catch (DAOException ex){
         throw new FacadeException("Erro ao buscar por id",ex );}
    }

    public static void aterarUsuario(Usuario u) throws FacadeException { 
       try(ConnectionFactory con = new ConnectionFactory()){
           UsuarioDAO dao= new UsuarioDAO(con.getConnection());
           dao.alterarUsuario(u);
       }
       catch (DAOException ex){
           throw new FacadeException("Erro ao alterar usuario",ex );
       }
    }

   
    public static void adicionarColaborador(Usuario colab) throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
         UsuarioDAO dao= new UsuarioDAO(con.getConnection());
         dao.adicionarColaborador(colab);
         }
         catch (DAOException ex){
           throw new FacadeException("Erro ao adicionar colaborador",ex );
       }
    }

    public static List<Usuario> buscarColaboradores() throws FacadeException {
    try(ConnectionFactory con = new ConnectionFactory()){
         UsuarioDAO dao= new UsuarioDAO(con.getConnection());
         return dao.buscarColaboradores();
    }catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar lista de colaboradores ", ex);
    }
    }

    public static void removerUsuario(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
           UsuarioDAO dao= new UsuarioDAO(con.getConnection());
           dao.removerUsuario(id);
       }
       catch (DAOException ex){
           throw new FacadeException("Erro ao remover usuario",ex );
       }
    }
     
}
