/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.exception.DAOException;
import java.sql.SQLException;
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
   private static final String QUERY_INSERIR_CLIENTE = "INSERT INTO tb_usuario(nome, email, cpf, cep, rua, nr, complemento, bairro, cidade, uf, senha, tipo, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, MD5(?),?,?);";
   
   private static final String QUERY_BUSCAR_LOGIN= "SELECT * FROM tb_usuario WHERE email = ? AND senha = MD5(?) ";
    
   private static final String QUERY_BUSCAR_POR_ID= "SELECT id, nome, email, telefone, cpf, cep, rua, nr, complemento, bairro, cidade, uf, tipo FROM tb_usuario WHERE id= ? ;";
    
   private static final String QUERY_ALTERAR= "UPDATE tb_usuario SET nome=?, email=?, cpf=?, cep=?, rua=?, nr=?, complemento=?, bairro=?, cidade=?, uf=?, senha=MD5(?), tipo=?, telefone=? WHERE id=?;";
   
         

    
    private Connection con= null;
    
    public UsuarioDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
    
    
     public void  adicionarCliente(Usuario c) throws DAOException {
        
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_CLIENTE)){         
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
            st.setString(13, c.getTelefone());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao inserir Cliente: " + QUERY_INSERIR_CLIENTE,e);           
        }
        
        
    }
     
    public Usuario login(String email, String senha)throws DAOException {
       
        Usuario user = null;
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_LOGIN)){
            
            st.setString(1, email);
            st.setString(2, senha);
            try(ResultSet rs = st.executeQuery()){     
                while(rs.next()) {
                    user = new Usuario(rs.getInt("id"), 
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("email"),
                            rs.getString("telefone"),
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
            }
        } catch (SQLException e) {
             throw new DAOException("Erro ao buscar usuário: " + QUERY_BUSCAR_LOGIN,e); 
        }
        return user;
    }
    
     public Usuario buscaPorId(int id) throws DAOException {
        Usuario user = new Usuario();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)){
            st.setInt(1,id);
           try(ResultSet rs = st.executeQuery()){
           if (rs.next()) {
                user = new Usuario(rs.getInt("id"), 
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getInt("nr"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("tipo"));
           }
               
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar usuário: " + QUERY_BUSCAR_POR_ID,e); 
        }
        return user;
    }
    
     
      public void alterarUsuario(Usuario u) throws DAOException {
      
        try(PreparedStatement st = con.prepareStatement(QUERY_ALTERAR)){
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
            st.setString(13, u.getTelefone());
            st.setInt(14, u.getId());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erro ao atualizar usuário: " + QUERY_ALTERAR,e); 
        }
    }

   
    public void  adicionarColaborador(Usuario colab) throws DAOException {
        
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_CLIENTE)){         
            st.setString(1, colab.getNome());
            st.setString(2, colab.getEmail());
            st.setString(3, colab.getCpf());
            st.setString(4, colab.getCep());
            st.setString(5, colab.getRua());
            st.setInt(6, colab.getNr());
            st.setString(7, colab.getComplemento());
            st.setString(8, colab.getBairro());
            st.setString(9, colab.getCidade());
            st.setString(10, colab.getUf());
            st.setString(11, colab.getSenha());
            st.setString(12, colab.getTipo());
            st.setString(13, colab.getTelefone());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao inserir Colaborador: " + QUERY_INSERIR_CLIENTE,e);           
        }
        
        
    }
    
    
}






    
