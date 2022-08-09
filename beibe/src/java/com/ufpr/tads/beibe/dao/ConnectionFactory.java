/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufpr.tads.beibe.dao;

/**
 *
 * @author grupo2
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable{
    public static String DRIVER= "org.postgresql.Driver"; //trocar para o proprio
    public static String URL= "jdbc:postgresql://localhost:5432/Beibe"; //trocar para o proprio
    public static String LOGIN= "postgres"; //trocar para o proprio
    public static String SENHA= "SENHA"; //trocar para o proprio
    private Connection con= null;
    
    public Connection getConnection() {
        if(con== null) {
            try{Class.forName(DRIVER);
            con= DriverManager.getConnection(URL, LOGIN, SENHA);
            }
            catch(ClassNotFoundException e) {
                throw new RuntimeException("Driver do banco não encontrado: "+ 
                        DRIVER, e);
            }
            catch(SQLException e) {
                throw new RuntimeException("Erro conectando ao BD: "+ URL+
                        "/"+ LOGIN+ "/"+ SENHA, e);
            }
        }
        return con;
    }
    
    @Override
        public void close() {
            if(con!=null) {
                try{ con.close();
                con= null;
                }
                catch(Exception e) { 
                    System.out.println("Errofechandoa conexão. IGNORADO");
                    e.printStackTrace();
                }
            }
        }
}


