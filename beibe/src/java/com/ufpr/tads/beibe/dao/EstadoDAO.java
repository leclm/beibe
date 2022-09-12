/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import com.ufpr.tads.beibe.exception.DAOException;
import java.sql.Connection;
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
public class EstadoDAO {

    
    private static final String QUERY_BUSCAR = "select id, nome, sigla from estado";
    
    private Connection con= null;
  
    
    public EstadoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Falha na Conexão com o Banco de Dados.");
        }
        this.con = con;
    }
   
    public List<Estado> buscarTudo()throws DAOException {
        
        List<Estado> estados = new ArrayList<Estado>();
        
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)){

            try(ResultSet rs = st.executeQuery()){   
                while(rs.next()){
                        Estado estado = new Estado();
                        estado.setId(rs.getInt(1));
                        estado.setNome(rs.getString(2));
                        estado.setSigla(rs.getString(3));  
                        estados.add(estado);

                }  
            }    
        } catch (SQLException e) {
            throw new DAOException("Erro ao inserir Cliente: " + QUERY_BUSCAR,e); 
        }
        return  estados;
    }
}
