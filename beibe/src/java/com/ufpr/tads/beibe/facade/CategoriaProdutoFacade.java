/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.dao.CategoriaProdutoDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.exception.DAOException;
import com.ufpr.tads.beibe.exception.FacadeException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CategoriaProdutoFacade {
    public static List<CategoriaProduto> BuscarTudo() throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
            return dao.buscarTudo();
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar categorias:\n ", ex);
       }
    }
    
    public static void AdicionarCategoriaProduto(CategoriaProduto p) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
            dao.AdicionarCategoriaProduto(p);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao adicionar categoria:\n ", ex);
       }
    }

    public static void AlterarCategoriaProduto(CategoriaProduto p) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
            dao.AlterarCategoriaProduto(p);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao alterar categoria:\n ", ex);
       }
    }

    public static void RemoverCategoriaProduto(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
            dao.RemoverCategoriaProduto(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao remover categoria:\n ", ex);
       }
    }
    
    public static CategoriaProduto buscarCategoriaPorId(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
            return dao.buscarCategoriaPorId(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar categoria pelo identificador:\n ", ex);
       }
    }
}
