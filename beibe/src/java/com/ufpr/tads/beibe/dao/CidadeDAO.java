/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import com.ufpr.tads.beibe.beans.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CidadeDAO {
    private static final String QUERY_BUSCAR_POR_ID = "select id, nome, idestado from cidade where id = ?";
    private static final String QUERY_BUSCAR = "select id, nome, idestado from cidade";
    
    private Connection con= null;
    
    public static Cidade buscar(int id){
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cidade cidade = null;
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR_POR_ID);
        st.setInt(1, id);
        rs = st.executeQuery();    
            while(rs.next()){
                cidade = new Cidade();
                cidade.setId(rs.getInt(1));
                cidade.setNome(rs.getString(2));
                Estado estado = new Estado();
                estado.setId(rs.getInt(3));
                cidade.setEstado(estado);
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  cidade;
    }
    
    public static List<Cidade> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<Cidade>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    Cidade cidade = new Cidade();
                    cidade.setId(rs.getInt(1));
                    cidade.setNome(rs.getString(2));
                    Estado estado = new Estado();
                    estado.setId(rs.getInt(3));
                    cidade.setEstado(estado);
                    cidades.add(cidade);     
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  cidades;
    }
    
    
}
