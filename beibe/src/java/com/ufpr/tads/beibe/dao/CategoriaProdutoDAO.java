/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;


import com.ufpr.tads.beibe.beans.CategoriaProduto;
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
public class CategoriaProdutoDAO {
    
    private static final String QUERY_BUSCAR = "select id, nome from tb_categoriaproduto";
    
    private Connection con= null;
    
    public static List<CategoriaProduto> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CategoriaProduto> categoriasPrd= new ArrayList<CategoriaProduto>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    CategoriaProduto categoriaProduto = new CategoriaProduto();
                    categoriaProduto.setId(rs.getInt(1));
                    categoriaProduto.setNome(rs.getString(2));
                    categoriasPrd.add(categoriaProduto);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  categoriasPrd;
    }
    
}
