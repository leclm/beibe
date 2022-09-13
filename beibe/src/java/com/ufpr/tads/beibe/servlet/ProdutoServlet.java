/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.exception.FacadeException;
import com.ufpr.tads.beibe.facade.ProdutoFacade;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author grupo2
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
                    case "listarProduto":
                        List<Produto> listProduto = ProdutoFacade.buscarProdutos();
                        request.setAttribute("listProduto", listProduto);

                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                        rd.forward(request, response);

                        break;
                    case "cadastroProduto":
                        ProdutoFacade.ApresentarCategorias(request);

                        rd = getServletContext().getRequestDispatcher("/cadastroProduto.jsp");
                        rd.forward(request, response);

                        break;
                    case "adicionarProduto":
                        Produto produto = new Produto();

                        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
                        CategoriaProduto ctg = new CategoriaProduto();
                        ctg.setId(idcategoria);

                        int peso = Integer.parseInt(request.getParameter("peso"));
                        String nome = (String) request.getParameter("nome");
                        String descricao = (String) request.getParameter("descricao");

                        produto.setCategoriaProduto(ctg);
                        produto.setPeso(peso);
                        produto.setNome(nome);
                        produto.setDescricao(descricao);

                        ProdutoFacade.AdicionarProduto(produto);

                        listProduto = ProdutoFacade.buscarProdutos();
                        request.setAttribute("listProduto", listProduto);

                        rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                        rd.forward(request, response);

                        break;
                    case "alteraProduto":
                        int id = Integer.parseInt(request.getParameter("id"));

                        produto = ProdutoFacade.buscarProdutoPorId(id);
                        ProdutoFacade.ApresentarCategorias(request);

                        request.setAttribute("produto", produto);
                        rd = getServletContext().getRequestDispatcher("/atualizaProduto.jsp");
                        rd.forward(request, response);

                        break;
                    case "salvarAlteraProduto":
                        produto = new Produto();

                        id = Integer.parseInt(request.getParameter("id"));

                        idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
                        ctg = new CategoriaProduto();
                        ctg.setId(idcategoria);

                        peso = Integer.parseInt(request.getParameter("peso"));
                        nome = (String) request.getParameter("nome");
                        descricao = (String) request.getParameter("descricao");

                        produto.setId(id);
                        produto.setCategoriaProduto(ctg);
                        produto.setPeso(peso);
                        produto.setNome(nome);
                        produto.setDescricao(descricao);

                        ProdutoFacade.AlterarProduto(produto);

                        listProduto = ProdutoFacade.buscarProdutos();
                        request.setAttribute("listProduto", listProduto);

                        rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                        rd.forward(request, response);

                        break;
                    case "removerProduto":
                        id = Integer.parseInt(request.getParameter("id"));

                        ProdutoFacade.RemoverProduto(id);

                        listProduto = ProdutoFacade.buscarProdutos();
                        request.setAttribute("listProduto", listProduto);

                        rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                        rd.forward(request, response);

                        break;
                    case "visualizarProduto":
                        id = Integer.parseInt(request.getParameter("id"));

                        produto = ProdutoFacade.buscarProdutoPorId(id);
                        ProdutoFacade.ApresentarCategorias(request);

                        request.setAttribute("produto", produto);
                        rd = getServletContext().getRequestDispatcher("/visualizaProduto.jsp");
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
