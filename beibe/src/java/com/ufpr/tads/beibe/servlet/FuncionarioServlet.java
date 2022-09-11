/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.beans.LoginBean;
import com.ufpr.tads.beibe.facade.AtendimentoFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author grupo2
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
              
        if(action==null || action.equals("list")){
           /* List<Cliente> clientes = ClientesFacade.listarTodos();
            request.setAttribute("listaClientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("/clientesListar.jsp");
            rd.forward(request, response);*/
        } else{            
            switch (action) {
                case "salvarAtendimento":
                    //Valores pegos do formulario, já no formato para BD
                    String status = request.getParameter("status");
                    
                    //cria novos objetos
                    Atendimento a = (Atendimento) request.getAttribute("atd");
                    
                    //adiciona os valores a esse objeto
                    a.setSolucao(status);
                   
                    //função para inserir no bd via Facade
                    AtendimentoFacade.alterarAtendimento(a);
                    
                    //redireciona
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/FuncionarioServlet?action=mostrarPortalFuncionario");
                    rd.forward(request, response);
                    
                    break;
                case "mostrarAtendimento":
                    HttpSession session = request.getSession();
                    LoginBean user = (LoginBean)session.getAttribute("user");
                    
                    int idu = user.getId();
                    String nomeu = user.getNome();
                    int ida = Integer.parseInt(request.getParameter("id"));
                    
                    //Carrega o atendimento de atendimentos para apresentar
                    Atendimento atd = AtendimentoFacade.buscarAtendimentoPorIdAtd(idu, ida);

                    //ADD OBJ NA REQUISIÇÃO
                    request.setAttribute("atd", atd);
                    request.setAttribute("nomeu", nomeu);

                    //redireciona
                    rd = getServletContext().getRequestDispatcher("/atualizaAtendimento.jsp");
                    rd.forward(request, response);

                    break;
                case "mostrarPortalFuncionario":
                    //Carrega a lista de atendimentos para apresentar
                    List<Atendimento> atendimentos = AtendimentoFacade.buscarTudo();

                    //ADD OBJ NA REQUISIÇÃO
                    request.setAttribute("atendimentos", atendimentos);

                    //redireciona
                    rd = getServletContext().getRequestDispatcher("/atendimentos.jsp");
                    rd.forward(request, response);

                    break;
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
