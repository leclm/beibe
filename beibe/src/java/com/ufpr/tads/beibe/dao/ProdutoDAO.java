/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;


import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
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
public class ProdutoDAO {
    private static final String QUERY_BUSCAR = "SELECT p.id, p.nome,c.nome as categoria, p.descricao, p.peso FROM tb_produto as p INNER JOIN tb_categoriaproduto as c on  p.idcategoria= c.id;";
    
    private Connection con= null;
    
    public static List<Produto> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Produto> produtos= new ArrayList<Produto>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    Produto produto = new Produto();
                    CategoriaProduto categoria = new CategoriaProduto();
                    produto.setId(rs.getInt(1));
                    produto.setNome(rs.getString(2));
                    categoria.setNome(rs.getString(3));
                    produto.setDescricao(rs.getString(4));
                    produto.setPeso(rs.getInt(5));
                    produtos.add(produto);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  produtos;
    }
    
}
