/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.beans.SituacaoAtendimento;
import com.ufpr.tads.beibe.beans.Usuario;
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
public class AtendimentoDAO {
    private static final String QUERY_BUSCA_TUDO_CLIENTE = "SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento where  u.id=? order by a.dt_hr desc";
    
    private static final String QUERY_BUSCA_TUDO = "SELECT a.id, a.dt_hr, a.id_cliente, p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento order by a.dt_hr asc";
    
    private static final String QUERY_INSERIR_ATENDIMENTO = "INSERT INTO tb_atendimento	(id_cliente, id_situacao, id_produto, id_categoria_atendimento, descricao, solucao) VALUES (?, ?, ?, ?, ?,?);";
    
    private static final String QUERY_BUSCA_TUDO_ATENDIMENTO = "SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao FROM public.tb_atendimento as a INNER JOIN tb_usuario as u on u.id=a.id_cliente INNER JOIN tb_situacao_atendimento as s on s.id=a.id_situacao INNER JOIN tb_produto as p on p.id=a.id_produto INNER JOIN tb_categoria_atendimento as cat on cat.id=a.id_categoria_atendimento where  u.id=?  and a.id=?";
    
    private static final String QUERY_REMOVER_ATENDIMENTO ="DELETE FROM tb_atendimento WHERE id=?";
    
    private static final String QUERY_ALTERAR_ATENDIMENTO = "UPDATE tb_atendimento SET id_situacao=?,solucao=? WHERE id=?";
    
    private final String QUERY_QNT_ANTEDIMENTOS_TOTAL = "SELECT count(*) as qntAtendimentos FROM tb_atendimento";
    
    private final String QUERY_QNT_ATENDIMENTOS_ABERTOS = "select count (a.id_categoria_atendimento) as atendimentosabertos from tb_atendimento a \n" +
                        "inner join tb_situacao_atendimento sa on (a.id_situacao = sa.id) \n" +
                        "where sa.nome = 'Aberta'";
    
    private final String QUERY_QNT_ANTEDIMENTOS_TOTAL_BY_CATEGORIA_ATENDIMENTO_ID = "select count (a.id_categoria_atendimento) \n" +
                        "as atendimentosabertos from tb_atendimento a\n" +
                        "inner join tb_categoria_atendimento tca on (a.id_categoria_atendimento = tca.id)\n" +
                        "inner join tb_situacao_atendimento sa on (a.id_situacao = sa.id)\n" +
                        "where tca.id = ?";
    
    private final String QUERY_QNT_ANTEDIMENTOS_ABERTOS_BY_CATEGORIA_ATENDIMENTO_ID = "select count (a.id_categoria_atendimento) \n" +
                        "as atendimentosabertos from tb_atendimento a\n" +
                        "inner join tb_categoria_atendimento tca on (a.id_categoria_atendimento = tca.id)\n" +
                        "inner join tb_situacao_atendimento sa on (a.id_situacao = sa.id)\n" +
                        "where tca.id = ? and sa.nome = 'Aberta'";
    
    private Connection con= null;
    
    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
    
    public void adicionarAtendimento(Atendimento a) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ATENDIMENTO)) {
            st.setInt(1, a.getId());
            st.setInt(2, 1);
            st.setInt(3, a.getProduto().getId());
            st.setInt(4, a.getCategoriaAtendimento().getId());
            st.setString(5, a.getDescricao());
            st.setString(6, "");
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public void alterarAtendimento(Atendimento a) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ALTERAR_ATENDIMENTO)) {
            st.setInt(1, a.getSituacaoAtendimento().getId());
            st.setString(2, a.getSolucao());
            st.setInt(3, a.getId());
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public List<Atendimento> buscarTudoCliente(int id) throws DAOException {
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCA_TUDO_CLIENTE)) {
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();  
        
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
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return  atendimentos;
    }
    
     public List<Atendimento> buscarTudoIdAtendimento(int idu, int ida) throws DAOException {
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCA_TUDO_ATENDIMENTO)) {
            st.setInt(1,idu);
            st.setInt(2,ida);
            ResultSet rs = st.executeQuery();  
        
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
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return  atendimentos;
    }
    
     public Atendimento buscarTudoIdAtd(int idu, int ida) throws DAOException {
        Atendimento atendimento = new Atendimento();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCA_TUDO_ATENDIMENTO)) {
            st.setInt(1,idu);
            st.setInt(2,ida);
            ResultSet rs = st.executeQuery();
        
            while(rs.next()){
                //SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao 
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
            }  
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        
        return  atendimento;
    }
    
    public List<Atendimento> buscarTudo() throws DAOException {
        List<Atendimento> atendimentos= new ArrayList<>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCA_TUDO)) {
            ResultSet rs = st.executeQuery();  
        
            while(rs.next()){
                //SELECT a.id, a.dt_hr,  p.nome, cat.nome, a.descricao, s.nome, a.solucao 
                Atendimento atendimento = new Atendimento();
                Produto produto = new Produto();
                CategoriaAtendimento categoria = new CategoriaAtendimento();
                SituacaoAtendimento situacao = new SituacaoAtendimento();
                Usuario user = new Usuario();

                atendimento.setId(rs.getInt(1));
                java.util.Date dt = new java.util.Date(rs.getTimestamp(2).getTime());
                atendimento.setDataHr(dt);
                user.setId(rs.getInt(3));
                atendimento.setCliente(user);
                produto.setNome(rs.getString(4));
                atendimento.setProduto(produto);
                categoria.setNome(rs.getString(5));
                atendimento.setCategoriaAtendimento(categoria);
                atendimento.setDescricao(rs.getString(6));
                situacao.setNome(rs.getString(7));
                atendimento.setSituacaoAtendimento(situacao);
                atendimento.setSolucao(rs.getString(8));
                
                atendimentos.add(atendimento);
            }  
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        
        return  atendimentos;
    }
     
    public void removerAtendimento(int id) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_REMOVER_ATENDIMENTO)) {
            st.setInt(1, id);
            st.executeUpdate();
         } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public int getQuantidadeAtendimentosTodos() throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_QNT_ANTEDIMENTOS_TOTAL)) {
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public int getQuantidadeAtendimentosAbertos() throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_QNT_ATENDIMENTOS_ABERTOS)) {
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public int queryQuantidadeAtendimentosByCategoriaAtendimentoId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_QNT_ANTEDIMENTOS_TOTAL_BY_CATEGORIA_ATENDIMENTO_ID)) {
            st.setInt(1, id);
            
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public int queryQuantidadeAtendimentosAbertosByCategoriaAtendimentoId(int id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_QNT_ANTEDIMENTOS_ABERTOS_BY_CATEGORIA_ATENDIMENTO_ID)) {
            st.setInt(1, id);
            
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
}
