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
    
    private static final String QUERY_BUSCAR 
            = "SELECT id, nome FROM tb_categoriaproduto";
    private static final String QUERY_ADICIONAR
            = "INSERT INTO tb_categoriaproduto (nome) VALUES (?)";
    private static final String QUERY_ALTERAR
            = "UPDATE tb_categoriaproduto SET nome = ? WHERE id = ?";
    private static final String QUERY_REMOVER
            = "DELETE FROM tb_categoriaproduto WHERE id = ?";
    private static final String QUERY_CATEGORIA = "SELECT nome FROM tb_categoriaproduto WHERE id = ?";
    
    public static List<CategoriaProduto> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CategoriaProduto> categoriasPrd = new ArrayList<CategoriaProduto>();
        
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
    
    public static boolean AdicionarCategoriaProduto(CategoriaProduto ctg) {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            
            st = con.prepareStatement(QUERY_ADICIONAR);
                    
            st.setString(1, ctg.getNome());
            
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void AlterarCategoriaProduto(CategoriaProduto ctg) {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            
            st = con.prepareStatement(QUERY_ALTERAR);
            
            st.setString(1, ctg.getNome());
            st.setInt(2, ctg.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void RemoverCategoriaProduto(int id) {
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            
            st = con.prepareStatement(QUERY_REMOVER);
            
            st.setInt(1, id);
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static CategoriaProduto buscarCategoriaPorId(int id) {
        Connection con = null;
        PreparedStatement st = null;
        CategoriaProduto ctg = null;
        
        try {
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            
            st = con.prepareStatement(QUERY_CATEGORIA);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            try {
                while(rs.next()){
                    ctg = new CategoriaProduto();
                    
                    ctg.setId(id);
                    ctg.setNome(rs.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ctg;
    }
    
}
