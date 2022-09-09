/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
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
public class CategoriaAtendimentoDAO {
    
    private static final String QUERY_BUSCAR = "select id, nome from tb_categoria_atendimento";
    
    private Connection con= null;
    
    public static List<CategoriaAtendimento> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CategoriaAtendimento> categoriasAtd = new ArrayList<CategoriaAtendimento>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    CategoriaAtendimento categoriaAtendimento = new CategoriaAtendimento();
                    categoriaAtendimento.setId(rs.getInt(1));
                    categoriaAtendimento.setNome(rs.getString(2));
                    categoriasAtd.add(categoriaAtendimento);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  categoriasAtd;
    }
    
}
