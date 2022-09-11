/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.beans.SituacaoAtendimento;
import com.ufpr.tads.beibe.beans.Usuario;
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
public class AtendimentoDAO {
    private static final String QUERY_BUSCA_TUDO_CLIENTE = "SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento where  u.id=? order by a.dt_hr desc";
    
    private static final String QUERY_BUSCA_TUDO = "SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento order by a.dt_hr asc";
    
    private static final String QUERY_INSERIR_ATENDIMENTO = "INSERT INTO tb_atendimento	(id_cliente, id_situacao, id_produto, id_categoria_atendimento, descricao, solucao) VALUES (?, ?, ?, ?, ?,?);";
    
    private static final String QUERY_BUSCA_TUDO_ATENDIMENTO = "SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento where  u.id=?  and a.id=?";
    
    private static final String QUERY_REMOVER_ATENDIMENTO ="DELETE FROM tb_atendimento WHERE id=?";
    
    private static final String QUERY_ALTERAR_ATENDIMENTO = "UPDATE tb_atendimento SET solucao=? WHERE id=?";
    
    
    
    private Connection con= null;
    
    public static boolean adicionarAtendimento(Atendimento a) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
      
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_INSERIR_ATENDIMENTO);
           // java.util.Date dt = a.getDataHr();
           // st.setTimestamp(1, new java.sql.Timestamp(dt.getTime()));
            st.setInt(1, a.getId());
            st.setInt(2, 1);
            st.setInt(3, a.getProduto().getId());
            st.setInt(4, a.getCategoriaAtendimento().getId());
            st.setString(5, a.getDescricao());
            st.setString(6, "");
            
            
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void alterarAtendimento(Atendimento a) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
      
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_ALTERAR_ATENDIMENTO);
            
            st.setString(1, a.getSolucao());
            st.setInt(2, a.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static List<Atendimento> buscarTudoCliente(int id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCA_TUDO_CLIENTE);
        st.setInt(1,id);
        rs = st.executeQuery();  
        
            while(rs.next()){
                //SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao 
                        
                    Atendimento atendimento = new Atendimento();
                    Produto produto = new Produto();
                    CategoriaAtendimento categoria = new CategoriaAtendimento();
                    SituacaoAtendimento situacao = new SituacaoAtendimento();
                    
                    atendimento.setId(rs.getInt(1));
                    java.util.Date dt = new java.util.Date(
                                       rs.getTimestamp(2).getTime());
                    atendimento.setDataHr(dt);
                    produto.setNome(rs.getString(3));
                    atendimento.setProduto(produto);
                    categoria.setNome(rs.getString(4));
                    atendimento.setCategoriaAtendimento(categoria);
                    atendimento.setDescricao(rs.getString(5));
                    situacao.setNome(rs.getString(6));
                    atendimento.setSituacaoAtendimento(situacao);
                    atendimento.setSolucao(rs.getString(7));
                    
                    
                    
                    atendimentos.add(atendimento);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  atendimentos;
    }
    
     public static List<Atendimento> buscarTudoIdAtendimento(int idu, int ida) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCA_TUDO_ATENDIMENTO);
        st.setInt(1,idu);
        st.setInt(2,ida);
        rs = st.executeQuery();  
        
            while(rs.next()){
                //SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao 
                        
                    Atendimento atendimento = new Atendimento();
                    Produto produto = new Produto();
                    CategoriaAtendimento categoria = new CategoriaAtendimento();
                    SituacaoAtendimento situacao = new SituacaoAtendimento();
                    
                    atendimento.setId(rs.getInt(1));
                    java.util.Date dt = new java.util.Date(
                                       rs.getTimestamp(2).getTime());
                    atendimento.setDataHr(dt);
                    produto.setNome(rs.getString(3));
                    atendimento.setProduto(produto);
                    categoria.setNome(rs.getString(4));
                    atendimento.setCategoriaAtendimento(categoria);
                    atendimento.setDescricao(rs.getString(5));
                    situacao.setNome(rs.getString(6));
                    atendimento.setSituacaoAtendimento(situacao);
                    atendimento.setSolucao(rs.getString(7));       
                    atendimentos.add(atendimento);
                    
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  atendimentos;
    }
    
    public static List<Atendimento> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_BUSCA_TUDO);
            rs = st.executeQuery();  
        
            while(rs.next()){
                //SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao 
                        
                Atendimento atendimento = new Atendimento();
                Produto produto = new Produto();
                CategoriaAtendimento categoria = new CategoriaAtendimento();
                SituacaoAtendimento situacao = new SituacaoAtendimento();

                atendimento.setId(rs.getInt(1));
                java.util.Date dt = new java.util.Date(rs.getTimestamp(2).getTime());
                atendimento.setDataHr(dt);
                produto.setNome(rs.getString(3));
                atendimento.setProduto(produto);
                categoria.setNome(rs.getString(4));
                atendimento.setCategoriaAtendimento(categoria);
                atendimento.setDescricao(rs.getString(5));
                situacao.setNome(rs.getString(6));
                atendimento.setSituacaoAtendimento(situacao);
                atendimento.setSolucao(rs.getString(7));
                
                atendimentos.add(atendimento);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  atendimentos;
    }
     
    public static boolean removerAtendimento(int id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
            st = con.prepareStatement(QUERY_REMOVER_ATENDIMENTO);
            st.setInt(1, id);
            rs = st.executeQuery();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
