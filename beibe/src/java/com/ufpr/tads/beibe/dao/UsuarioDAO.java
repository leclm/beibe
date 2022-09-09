/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author grupo2
 */
public class UsuarioDAO implements DAO<Usuario>{
   private static final String QUERY_INSERIR_CLIENTE = "INSERT INTO tb_usuario(nome, email, cpf, cep, rua, nr, complemento, bairro, cidade, uf, senha, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
   
   private static final String QUERY_BUSCAR_LOGIN= "SELECT * FROM tb_usuario WHERE email = ? AND senha = ? ";
    
   private static final String QUERY_BUSCAR_POR_ID= "SELECT id, nome, email, cpf, cep, rua, nr, complemento, bairro, cidade, uf, senha, tipo FROM tb_usuario WHERE id= ? ;";
    
   private static final String QUERY_ALTERAR= "UPDATE tb_usuario SET nome=?, email=?, cpf=?, cep=?, rua=?, nr=?, complemento=?, bairro=?, cidade=?, uf=?, senha=?, tipo=? WHERE id=?;";
   
    
    /*private static final String QUERY_BUSCAR_TODOS= 
            "SELECT id_cliente, cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente"+
            "FROM tb_cliente";
    
    private static final String QUERY_BUSCAR_ID= 
            "SELECT * FROM tb_cliente WHERE id_cliente = (?)";
    
    private static final String QUERY_REMOVER= 
            "DELETE FROM tb_cliente WHERE id_cliente = (?)";
    
    private static final String QUERY_ATUALIZAR= "UPDATE tb_cliente SET  cpf_cliente=?, nome_cliente=?, email_cliente=?, data_cliente=?, rua_cliente=?, nr_cliente=?, cep_cliente=?, cidade_cliente=?, uf_cliente=? WHERE id_cliente = (?)";
    */      

    
    private Connection con= null;
    
    
     public static boolean adicionarCliente(Usuario c) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
      
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_INSERIR_CLIENTE);
            st.setString(1, c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3, c.getCpf());
            st.setString(4, c.getCep());
            st.setString(5, c.getRua());
            st.setInt(6, c.getNr());
            st.setString(7, c.getComplemento());
            st.setString(8, c.getBairro());
            st.setString(9, c.getCidade());
            st.setString(10, c.getUf());
            st.setString(11, c.getSenha());
            st.setString(12, "cliente");
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    public static Usuario login(String email, String senha) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario user;
        try {
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_BUSCAR_LOGIN);
            st.setString(1, email);
            st.setString(2, senha);
            rs = st.executeQuery();
            if (rs.next()) {
                user = new Usuario(rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getInt("nr"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("senha"),
                        rs.getString("tipo"));
            } else {
                user = new Usuario();
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public static Usuario buscaPorId(int id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario user = new Usuario();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_BUSCAR_POR_ID);
            st.setInt(1,id);
            rs = st.executeQuery();
           if (rs.next()) {
                user = new Usuario(rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getInt("nr"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("senha"),
                        rs.getString("tipo"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
     
      public static void alterarUsuario(Usuario u) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
      
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_ALTERAR);
            st.setString(1, u.getNome());
            st.setString(2, u.getEmail());
            st.setString(3, u.getCpf());
            st.setString(4, u.getCep());
            st.setString(5, u.getRua());
            st.setInt(6, u.getNr());
            st.setString(7, u.getComplemento());
            st.setString(8, u.getBairro());
            st.setString(9, u.getCidade());
            st.setString(10, u.getUf());
            st.setString(11, u.getSenha());
            st.setString(12, u.getTipo());
            st.setInt(13, u.getId());
            st.executeUpdate();
            return;
            
        } catch (Exception e) {
            e.printStackTrace();
           return;
        }
    }
    
    
}






    
