/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class EstadoDAO {

    
    private static final String QUERY_BUSCAR = "select id, nome, sigla from estado";
    
    private Connection con= null;
    
   /* public List<Estado> buscarTodos(){
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<Estado>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    Estado estado = new Estado();
                    estado.setId(rs.getInt(1));
                    estado.setNome(rs.getString(2));
                    estado.setSigla(rs.getString(3));  
                    estados.add(estado);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  estados;
    }*/
    
    public static List<Estado> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<Estado>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    Estado estado = new Estado();
                    estado.setId(rs.getInt(1));
                    estado.setNome(rs.getString(2));
                    estado.setSigla(rs.getString(3));  
                    estados.add(estado);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  estados;
    }
}
