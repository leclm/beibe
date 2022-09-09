/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.CategoriaProduto;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.facade.CategoriaProdutoFacade;
import com.ufpr.tads.beibe.facade.ProdutoFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
              
        if(action==null || action.equals("list")){
           /* List<Cliente> clientes = ClientesFacade.listarTodos();
            request.setAttribute("listaClientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("/clientesListar.jsp");
            rd.forward(request, response);*/
        } else{
            switch (action) {
                case "listarProduto": {
                    List<Produto> listProduto = ProdutoFacade.buscarProdutos();
                    request.setAttribute("listProduto", listProduto);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                    rd.forward(request, response);

                    break;
                }
                case "cadastroProduto": {
                    ProdutoFacade.ApresentarCategorias(request);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastroProduto.jsp");
                    rd.forward(request, response);

                    break;
                }
                case "adicionarProduto": {
                    Produto produto = new Produto();

                    int idCtg = Integer.parseInt(request.getParameter("idCategoriaProduto"));
                    String nomeCtg = (String) request.getParameter("nomeCategoriaProduto");
                    CategoriaProduto ctg = new CategoriaProduto(idCtg, nomeCtg);

                    int peso = Integer.parseInt(request.getParameter("peso"));
                    String nome = (String) request.getParameter("nome");
                    String descricao = (String) request.getParameter("descricao");

                    produto.setCategoriaProduto(ctg);
                    produto.setPeso(peso);
                    produto.setNome(nome);
                    produto.setDescricao(descricao);

                    ProdutoFacade.AdicionarProduto(produto);

                    List<Produto> listProduto = ProdutoFacade.buscarProdutos();
                    request.setAttribute("listProduto", listProduto);

                    List<CategoriaProduto> listCategoriaProduto = CategoriaProdutoFacade.BuscarTudo();
                    request.setAttribute("listCategoriaProduto", listCategoriaProduto);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/produtos.jsp");
                    rd.forward(request, response);

                    break;
                }
                case "alterarProduto": {
                    Produto produto = new Produto();

                    int idCtg = Integer.parseInt(request.getParameter("idCategoriaProduto"));
                    String nomeCtg = (String) request.getParameter("nomeCategoriaProduto");
                    CategoriaProduto ctg = new CategoriaProduto(idCtg, nomeCtg);

                    int peso = Integer.parseInt(request.getParameter("peso"));
                    String nome = (String) request.getParameter("nome");
                    String descricao = (String) request.getParameter("descricao");

                    produto.setCategoriaProduto(ctg);
                    produto.setPeso(peso);
                    produto.setNome(nome);
                    produto.setDescricao(descricao);

                    ProdutoFacade.AlterarProduto(produto);

                    List<Produto> listProduto = ProdutoFacade.buscarProdutos();
                    request.setAttribute("listProduto", listProduto);

                    List<CategoriaProduto> listCategoriaProduto = CategoriaProdutoFacade.BuscarTudo();
                    request.setAttribute("listCategoriaProduto", listCategoriaProduto);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarproduto.jsp");
                    rd.forward(request, response);

                    break;
                }
                case "removerProduto": {
                    int id = Integer.parseInt(request.getParameter("idProduto"));

                    ProdutoFacade.RemoverProduto(id);

                    List<Produto> listProduto = ProdutoFacade.buscarProdutos();
                    request.setAttribute("listProduto", listProduto);

                    List<CategoriaProduto> listCategoriaProduto = CategoriaProdutoFacade.BuscarTudo();
                    request.setAttribute("listCategoriaProduto", listCategoriaProduto);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastrarproduto.jsp");
                    rd.forward(request, response);

                    break;
                }
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
