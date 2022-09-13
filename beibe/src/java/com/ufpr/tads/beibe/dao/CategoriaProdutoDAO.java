/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;


import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    private Connection con= null;
    
    public CategoriaProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
    
    public List<CategoriaProduto> buscarTudo() throws DAOException {
        List<CategoriaProduto> categoriasPrd = new ArrayList<CategoriaProduto>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            ResultSet rs = st.executeQuery();    
            
            while(rs.next()){
                CategoriaProduto categoriaProduto = new CategoriaProduto();
                categoriaProduto.setId(rs.getInt(1));
                categoriaProduto.setNome(rs.getString(2));
                categoriasPrd.add(categoriaProduto);

            }  
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return  categoriasPrd;
    }
    
    public void AdicionarCategoriaProduto(CategoriaProduto ctg) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ADICIONAR);) {
            st.setString(1, ctg.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public void AlterarCategoriaProduto(CategoriaProduto ctg) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ALTERAR)) {
            st.setString(1, ctg.getNome());
            st.setInt(2, ctg.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public void RemoverCategoriaProduto(int id) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public CategoriaProduto buscarCategoriaPorId(int id) throws DAOException {
        CategoriaProduto ctg = null;
        
        try(PreparedStatement st = con.prepareStatement(QUERY_CATEGORIA)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                ctg = new CategoriaProduto();

                ctg.setId(id);
                ctg.setNome(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        
        return ctg;
    }
    
}
