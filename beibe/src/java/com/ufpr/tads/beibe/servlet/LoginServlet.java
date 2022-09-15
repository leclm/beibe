/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.LoginBean;
import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.dao.UsuarioDAO;
import com.ufpr.tads.beibe.exception.FacadeException;
import com.ufpr.tads.beibe.facade.UsuarioFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grupo2
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
       //Valores pegos do formulario
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
         
        if( email ==  null || senha == null || email.isEmpty() || senha.isEmpty()){
             request.setAttribute("msg", "Favor preencher todos os campos!");
             request.setAttribute("page", "index.jsp");
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
             rd.forward(request, response); 
         } 
                Usuario user;
        try {
            user = UsuarioFacade.login(email,senha);
            boolean isValid = user.getId() > 0 ? true : false;
                if (isValid) {
                   //Armazena o nome do usuário na sessão (indicando que o usuário está logado)
                        HttpSession session = request.getSession();
                        LoginBean bean = new LoginBean();
                        bean.setId(user.getId());
                        bean.setNome(user.getNome());
                        bean.setTipo(user.getTipo());
                        session.setAttribute("user", bean);

                        switch (user.getTipo()) {
                            case "cliente":
                                response.sendRedirect("AtendimentoServlet?action=mostrarPortalCliente");
                                break;
                            case "funcionario":
                                response.sendRedirect("FuncionarioServlet?action=mostrarPortalFuncionario");
                                break;
                            case "gerente":
                                response.sendRedirect("AtendimentoServlet?action=mostrarPortalGerente");
                                break;
                            default:
                               request.setAttribute("msg", " Usuário/Senha inválidos.");
                               request.setAttribute("page", "index.jsp");
                               RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                               break;
                        }    
                    } 
        }catch (FacadeException ex) {
                request.setAttribute("msg", " Usuário/Senha inválidos.");
                request.setAttribute("page", "index.jsp");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
