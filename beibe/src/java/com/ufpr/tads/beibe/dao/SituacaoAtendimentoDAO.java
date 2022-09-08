/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;


import com.ufpr.tads.beibe.beans.SituacaoAtendimento;
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
public class SituacaoAtendimentoDAO {
    private static final String QUERY_BUSCAR = "select id, nome from tb_situacao_atendimento";
    
    private Connection con= null;
    
    public static List<SituacaoAtendimento> buscarTudo() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<SituacaoAtendimento> situacoesAtd = new ArrayList<SituacaoAtendimento>();
        
        try{
            Class.forName(com.ufpr.tads.beibe.dao.ConnectionFactory.DRIVER);
            con = DriverManager.getConnection(com.ufpr.tads.beibe.dao.ConnectionFactory.URL, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.LOGIN, 
                                                com.ufpr.tads.beibe.dao.ConnectionFactory.SENHA);
        st = con.prepareStatement(QUERY_BUSCAR);
        rs = st.executeQuery();    
            while(rs.next()){
                    SituacaoAtendimento situacaoAtendimento = new SituacaoAtendimento();
                    situacaoAtendimento.setId(rs.getInt(1));
                    situacaoAtendimento.setNome(rs.getString(2));
                    situacoesAtd.add(situacaoAtendimento);
                }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  situacoesAtd;
    }
    
}
