/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.exception.FacadeException;
import com.ufpr.tads.beibe.facade.CategoriaProdutoFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(name = "CategoriaProdutoServlet", urlPatterns = {"/CategoriaProdutoServlet"})
public class CategoriaProdutoServlet extends HttpServlet {

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
              
        try{      
            if(action==null){
                //redireciona
                response.sendRedirect("LogoutServlet");
            } else{
                switch (action) {
                    case "listarCategoriaProduto":
                        List<CategoriaProduto> listCategorias = CategoriaProdutoFacade.BuscarTudo();
                        request.setAttribute("listCategorias", listCategorias);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/categorias.jsp");
                        rd.forward(request, response);

                        break;
                    case "cadastroCategoriaProduto":
                        rd = getServletContext().getRequestDispatcher("/cadastroCategoria.jsp");
                        rd.forward(request, response);

                        break;
                    case "adicionarCategoriaProduto":
                        String nome = request.getParameter("nome");
                        CategoriaProduto ctg = new CategoriaProduto();
                        ctg.setNome(nome);

                        CategoriaProdutoFacade.AdicionarCategoriaProduto(ctg);

                        listCategorias = CategoriaProdutoFacade.BuscarTudo();
                        request.setAttribute("listCategorias", listCategorias);

                        rd = getServletContext().getRequestDispatcher("/categorias.jsp");
                        rd.forward(request, response);

                        break;
                    case "alteraCategoriaProduto":
                        int id = Integer.parseInt(request.getParameter("id"));

                        ctg = CategoriaProdutoFacade.buscarCategoriaPorId(id);

                        request.setAttribute("categoria", ctg);
                        rd = getServletContext().getRequestDispatcher("/atualizaCategoria.jsp");
                        rd.forward(request, response);

                        break;
                    case "salvarAlteraCategoriaProduto":
                        id = Integer.parseInt(request.getParameter("id"));
                        nome = request.getParameter("nome");

                        ctg = new CategoriaProduto();
                        ctg.setId(id);
                        ctg.setNome(nome);

                        CategoriaProdutoFacade.AlterarCategoriaProduto(ctg);

                        listCategorias = CategoriaProdutoFacade.BuscarTudo();
                        request.setAttribute("listCategorias", listCategorias);

                        rd = getServletContext().getRequestDispatcher("/categorias.jsp");
                        rd.forward(request, response);

                        break;
                    case "removerCategoriaProduto":
                        id = Integer.parseInt(request.getParameter("id"));

                        CategoriaProdutoFacade.RemoverCategoriaProduto(id);

                        listCategorias = CategoriaProdutoFacade.BuscarTudo();
                        request.setAttribute("listCategorias", listCategorias);

                        rd = getServletContext().getRequestDispatcher("/categorias.jsp");
                        rd.forward(request, response);

                        break;
                }
            }
        } catch(FacadeException ex) {
            request.setAttribute("msg", ex);
            request.setAttribute("page", "LogoutServlet");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
            rd.forward(request, response);
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
