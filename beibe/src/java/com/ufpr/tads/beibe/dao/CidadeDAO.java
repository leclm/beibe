/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.exception.DAOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grupo2
 */
public class CidadeDAO {
    private static final String QUERY_BUSCAR_POR_ID = "select id, nome, idestado from cidade where id = ?";
    private static final String QUERY_BUSCAR = "select id, nome, idestado from cidade";
    
    private Connection con= null;
    
    
        public CidadeDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
    
    public Cidade buscar(int id)throws DAOException {
        
        Cidade cidade = null;
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_ID)){
        st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()){    
                while(rs.next()){
                    cidade = new Cidade();
                    cidade.setId(rs.getInt(1));
                    cidade.setNome(rs.getString(2));
                    Estado estado = new Estado();
                    estado.setId(rs.getInt(3));
                    cidade.setEstado(estado);
                }  
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao inserir Cliente: " + QUERY_BUSCAR_POR_ID,e); 
        }
        return  cidade;
    }
    
    public List<Cidade> buscarTudo() throws DAOException  {
        List<Cidade> cidades = new ArrayList<Cidade>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)){
            try(ResultSet rs = st.executeQuery()){    
                while(rs.next()){
                        Cidade cidade = new Cidade();
                        cidade.setId(rs.getInt(1));
                        cidade.setNome(rs.getString(2));
                        Estado estado = new Estado();
                        estado.setId(rs.getInt(3));
                        cidade.setEstado(estado);
                        cidades.add(cidade);     
                    }
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao inserir Cliente: " + QUERY_BUSCAR,e); 
        }
        return  cidades;
    }
    
    
}
