/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;


import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.exception.DAOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class ProdutoDAO {
    private static final String QUERY_ADICIONAR
            = "INSERT INTO tb_produto (nome, idcategoria, descricao, peso) VALUES (?, ?, ?, ?)";
    private static final String QUERY_ALTERAR
            = "UPDATE tb_produto SET nome = ?, idcategoria = ?, descricao = ?, peso = ? WHERE id = ?";
    private static final String QUERY_BUSCAR 
            = "SELECT p.id, p.nome,c.nome as categoria, p.descricao, p.peso "
            + "FROM tb_produto as p INNER JOIN tb_categoriaproduto as c on  p.idcategoria= c.id;";
    private static final String QUERY_REMOVER
            = "DELETE FROM tb_produto WHERE id = ?";
    private static final String QUERY_PRODUTO = "SELECT id, idcategoria, nome, descricao, peso FROM tb_produto WHERE id = ?";
    
    private Connection con= null;
    
    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
    
    public void AdicionarProduto(Produto p) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ADICIONAR)) {
            st.setString(1, p.getNome());
            st.setInt(2, p.getCategoriaProduto().getId());
            st.setString(3, p.getDescricao());
            st.setInt(4, p.getPeso());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public void AlterarProduto(Produto p) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ALTERAR)) {
            st.setString(1, p.getNome());
            st.setInt(2, p.getCategoriaProduto().getId());
            st.setString(3, p.getDescricao());
            st.setInt(4, p.getPeso());
            st.setInt(5, p.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public List<Produto> buscarTudo() throws DAOException {
        List<Produto> produtos= new ArrayList<Produto>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            ResultSet rs = st.executeQuery();    
            
            while(rs.next()){
                    Produto produto = new Produto();
                    CategoriaProduto categoria = new CategoriaProduto();
                    
                    produto.setId(rs.getInt(1));
                    produto.setNome(rs.getString(2));
                    categoria.setNome(rs.getString(3));
                    produto.setDescricao(rs.getString(4));
                    produto.setPeso(rs.getInt(5));
                    produto.setCategoriaProduto(categoria);
                    produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return  produtos;
    }
    
    public void RemoverProduto(int id) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public Produto buscarProdutoPorId(int id) throws DAOException {
        Produto produto = null;
        
        try(PreparedStatement st = con.prepareStatement(QUERY_PRODUTO)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                CategoriaProduto ctg = new CategoriaProduto();
                produto = new Produto();

                produto.setId(rs.getInt(1));

                ctg.setId(rs.getInt(2));

                produto.setCategoriaProduto(ctg);
                produto.setNome(rs.getString(3));
                produto.setDescricao(rs.getString(4));
                produto.setPeso(rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        
        return produto;
    }
}
