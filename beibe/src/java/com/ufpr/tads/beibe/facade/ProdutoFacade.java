/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.dao.CategoriaProdutoDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.dao.ProdutoDAO;
import com.ufpr.tads.beibe.exception.DAOException;
import com.ufpr.tads.beibe.exception.FacadeException;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class ProdutoFacade {
    public static void ApresentarCategorias(HttpServletRequest request) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            if (request.getSession().getAttribute("categorias") == null) {
                CategoriaProdutoDAO dao= new CategoriaProdutoDAO(con.getConnection());
                List<CategoriaProduto> categorias = dao.buscarTudo();
                request.setAttribute("categorias", categorias);
            }
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao apresentar categorias:\n ", ex);
       }
    }
    
    public static void AdicionarProduto(Produto p) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            ProdutoDAO dao= new ProdutoDAO(con.getConnection());
            dao.AdicionarProduto(p);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao adicionar produto:\n ", ex);
       }
    }

    public static void AlterarProduto(Produto p) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            ProdutoDAO dao= new ProdutoDAO(con.getConnection());
            dao.AlterarProduto(p);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao alterar produto:\n ", ex);
       }
    }

    public static void RemoverProduto(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            ProdutoDAO dao= new ProdutoDAO(con.getConnection());
            dao.RemoverProduto(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao remover produto:\n ", ex);
       }
    }
    
    public static List<Produto> buscarProdutos() throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            ProdutoDAO dao= new ProdutoDAO(con.getConnection());
            return dao.buscarTudo();
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar produtos:\n ", ex);
       }
    }
    
    public static Produto buscarProdutoPorId(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            ProdutoDAO dao= new ProdutoDAO(con.getConnection());
            return dao.buscarProdutoPorId(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar produtos pelo identificador:\n ", ex);
       }
    }
}
