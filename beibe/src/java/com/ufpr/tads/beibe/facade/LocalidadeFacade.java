/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import com.ufpr.tads.beibe.dao.CidadeDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.dao.EstadoDAO;
import com.ufpr.tads.beibe.exception.DAOException;
import com.ufpr.tads.beibe.exception.FacadeException;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class LocalidadeFacade {
    
    public static List<Estado> bucarTudoEstado() throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
         EstadoDAO dao= new EstadoDAO(con.getConnection());
         List<Estado> lista = dao.buscarTudo();
         return lista;
         }
         catch (DAOException ex){
           throw new FacadeException("Erro ao adicionar usuario",ex );
       }
    }
        public static List<Cidade> bucarTudoCidade() throws FacadeException {
         try(ConnectionFactory con = new ConnectionFactory()){
         CidadeDAO dao= new CidadeDAO(con.getConnection());
         List<Cidade> lista = dao.buscarTudo();
         return lista;
         }
         catch (DAOException ex){
           throw new FacadeException("Erro ao adicionar usuario",ex );
       }
    }
    
}
