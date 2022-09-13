/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.ufpr.tads.beibe.exception;

import java.sql.SQLException;

/**
 *
 * @author grupo2
 */
public class DAOException extends Exception {

    public DAOException(){
        super("Causa do Erro Desconhecida");
    }
    
    public DAOException(String msg, SQLException e) {
        super(msg+" / "+e.getMessage());
    }

    public DAOException (String msg, ClassNotFoundException e) {
        super(msg+" / "+e.getMessage());
    }

    public DAOException (String msg) {
        super(msg);
    }

    public DAOException(SQLException e) {
        super(e.getMessage());
    }
    
}
