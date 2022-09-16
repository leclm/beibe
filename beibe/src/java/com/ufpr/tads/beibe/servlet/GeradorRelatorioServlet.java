/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.dao.ConnectionFactory;
import com.ufpr.tads.beibe.exception.DAOException;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author grupo2
 */
@WebServlet(name = "GeradorRelatorioServlet", urlPatterns = {"/GeradorRelatorioServlet"})
public class GeradorRelatorioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     * @throws com.ufpr.tads.beibe.exception.DAOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, DAOException {
        response.setContentType("text/html;charset=UTF-8");
        
            Connection conn = null;
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            ServletContext sc = request.getServletContext();
       
        if("relatorioProdutosMaisReclamados".equals(action)){      
            try {
                conn = new ConnectionFactory().getConnection();
                // Caminho contextualizado do relatório compilado
                String jasper = request.getContextPath() + "/relatorioProdMaisRecla.jasper";
                // Host onde o servlet esta executando 
                String host = "http://" + request.getServerName() + ":" + request.getServerPort(); 
                System.out.println(host+jasper);
                // URL para acesso ao relatório
                URL jasperURL = new URL(host + jasper);

                // Parâmetros do relatório
                HashMap params = new HashMap();
                // Geração do relatório

                byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                if (bytes != null) { 
                   // A página será mostrada em PDF
                   response.setContentType("application/pdf");
                   // Envia o PDF para o Cliente
                   OutputStream ops = response.getOutputStream();  
                   ops.write(bytes);  
                } 
            } // Fechamento do try

            catch(JRException e) {
               request.setAttribute("mensagem", "Erro no Jasper : " + e.getMessage());
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }    
        }
        
         if("relatorioFuncionarios".equals(action)){    
            try {
                conn = new ConnectionFactory().getConnection();
                // Caminho contextualizado do relatório compilado
                String jasper = request.getContextPath() + "/relatorioFuncionario.jasper";
                // Host onde o servlet esta executando 
                String host = "http://" + request.getServerName() + ":" + request.getServerPort(); 
                System.out.println(host+jasper);
                // URL para acesso ao relatório
                URL jasperURL = new URL(host + jasper);

                // Parâmetros do relatório
                HashMap params = new HashMap();
                // Geração do relatório

                byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                if (bytes != null) { 
                   // A página será mostrada em PDF
                   response.setContentType("application/pdf");
                   // Envia o PDF para o Cliente
                   OutputStream ops = response.getOutputStream();  
                   ops.write(bytes);  
                } 
            } // Fechamento do try

            catch(JRException e) {
               request.setAttribute("mensagem", "Erro no Jasper : " + e.getMessage());
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }    
        }
     
     
     if("relatorioReclamacoesEmAberto".equals(action)){    
            try {
                conn = new ConnectionFactory().getConnection();
                // Caminho contextualizado do relatório compilado
                String jasper = request.getContextPath() + "/relatorioReclamacoesEmAberto.jasper";
                // Host onde o servlet esta executando 
                String host = "http://" + request.getServerName() + ":" + request.getServerPort(); 
                System.out.println(host+jasper);
                // URL para acesso ao relatório
                URL jasperURL = new URL(host + jasper);

                // Parâmetros do relatório
                HashMap params = new HashMap();
                // Geração do relatório

                byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                if (bytes != null) { 
                   // A página será mostrada em PDF
                   response.setContentType("application/pdf");
                   // Envia o PDF para o Cliente
                   OutputStream ops = response.getOutputStream();  
                   ops.write(bytes);  
                } 
            } // Fechamento do try

            catch(JRException e) {
               request.setAttribute("mensagem", "Erro no Jasper : " + e.getMessage());
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }   
        }
     
     if("relatorioTodasReclamacoes".equals(action)){    
            try {
                conn = new ConnectionFactory().getConnection();
                // Caminho contextualizado do relatório compilado
                String jasper = request.getContextPath() + "/relatorioReclamacoes.jasper";
                // Host onde o servlet esta executando 
                String host = "http://" + request.getServerName() + ":" + request.getServerPort(); 
                System.out.println(host+jasper);
                // URL para acesso ao relatório
                URL jasperURL = new URL(host + jasper);

                // Parâmetros do relatório
                HashMap params = new HashMap();
                // Geração do relatório

                byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                if (bytes != null) { 
                   // A página será mostrada em PDF
                   response.setContentType("application/pdf");
                   // Envia o PDF para o Cliente
                   OutputStream ops = response.getOutputStream();  
                   ops.write(bytes);  
                } 
            } // Fechamento do try

            catch(JRException e) {
               request.setAttribute("mensagem", "Erro no Jasper : " + e.getMessage());
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
     
     if("relatorioReclamacoesFechadas".equals(action)){    
            try {
                conn = new ConnectionFactory().getConnection();
                // Caminho contextualizado do relatório compilado
                String jasper = request.getContextPath() + "/relatorioReclamacoesFechadas.jasper";
                // Host onde o servlet esta executando 
                String host = "http://" + request.getServerName() + ":" + request.getServerPort(); 
                System.out.println(host+jasper);
                // URL para acesso ao relatório
                URL jasperURL = new URL(host + jasper);

                // Parâmetros do relatório
                HashMap params = new HashMap();
                // Geração do relatório

                byte[] bytes = JasperRunManager.runReportToPdf(jasperURL.openStream(), params, conn);
                if (bytes != null) { 
                   // A página será mostrada em PDF
                   response.setContentType("application/pdf");
                   // Envia o PDF para o Cliente
                   OutputStream ops = response.getOutputStream();  
                   ops.write(bytes);  
                } 
            } // Fechamento do try

            catch(JRException e) {
               request.setAttribute("mensagem", "Erro no Jasper : " + e.getMessage());
               request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
    }
    
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(GeradorRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(GeradorRelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
