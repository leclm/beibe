/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.facade;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.dao.AtendimentoDAO;
import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.exception.DAOException;
import com.ufpr.tads.beibe.exception.FacadeException;
import java.util.List;

/**
 *
 * @author grupo2
 */

public class AtendimentoFacade {
    public static void adicionarAtendimento(Atendimento a) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            dao.adicionarAtendimento(a);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao adicionar atendimento:\n ", ex);
       }
    }
     
    public static List<Atendimento> buscarAtendimentoPorCliente(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            return dao.buscarTudoCliente(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar atendimento por cliente:\n ", ex);
       }
    }
     
    public static List<Atendimento> buscarAtendimentoPorIdAtendimento(int idu, int ida) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            return dao.buscarTudoIdAtendimento(idu, ida);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar atendimento pelo seu identificador:\n ", ex);
       }
    }
    
    public static Atendimento buscarAtendimentoPorIdAtd(int idu, int ida) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            return dao.buscarTudoIdAtd(idu, ida);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar atendimento pelo seu identificador:\n ", ex);
       }
    }
     
    public static List<Atendimento> buscarTudo() throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            return dao.buscarTudo();
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao buscar todos os atendimentos:\n ", ex);
       }
    }
    
    public static void alterarAtendimento(Atendimento a) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
            AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
            dao.alterarAtendimento(a);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao alterar atendimento:\n ", ex);
       }
    }
     
    public static void removerAtendimento(int id) throws FacadeException {
        try(ConnectionFactory con = new ConnectionFactory()){
           AtendimentoDAO dao= new AtendimentoDAO(con.getConnection());
           dao.removerAtendimento(id);
        } catch (DAOException ex) {
           throw new FacadeException("[ERRO] ao remover atendimento:\n ", ex);
       }
    }
   
}
