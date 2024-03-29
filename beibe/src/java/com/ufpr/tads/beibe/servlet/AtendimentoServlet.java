/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
import com.ufpr.tads.beibe.beans.LoginBean;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.exception.FacadeException;
import com.ufpr.tads.beibe.facade.AtendimentoFacade;
import com.ufpr.tads.beibe.facade.CategoriaAtendimentoFacade;
import com.ufpr.tads.beibe.facade.ProdutoFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author grupo2
 */
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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
                     case "novoAtendimento":
                     
                        //Valores pegos do formulario, já no formato para BD 
                        HttpSession session = request.getSession();
                        LoginBean user = (LoginBean)session.getAttribute("user");
                    try{ 
                        int id = user.getId();
                        int produto =  Integer.parseInt(request.getParameter("produto"));   
                        int categoriaAtendimento = Integer.parseInt(request.getParameter("categoria"));
                        String descricao = request.getParameter("descricao");
                               
                        //cria novos objetos
                        Atendimento a = new Atendimento();

                        CategoriaAtendimento cat = new CategoriaAtendimento();
                        cat.setId(categoriaAtendimento);
                        Produto prod = new Produto();
                        prod.setId(produto);

                        //adiciona os valores a esse objeto
                        a.setId(id);
                        a.setProduto(prod);
                        a.setCategoriaAtendimento(cat);
                        a.setDescricao(descricao);
                        
                      
                        //função para inserir no bd via Facade
                        AtendimentoFacade.adicionarAtendimento(a);
                    } catch (NumberFormatException e){
                            //redireciona
                        request.setAttribute("msg", "Favor preencher todos os campos!");
                        request.setAttribute("page", "novoAtendimento.jsp");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=mostrarNovoAtendimento");
                        rd.forward(request, response);
                    }
                        
                        //redireciona
                        request.setAttribute("info", " Atendimento adicionado com sucesso!");
                        request.setAttribute("page", "portalCliente.jsp");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=mostrarPortalCliente");
                        rd.forward(request, response);
                        
                        break;  

                    case "mostrarNovoAtendimento":
                        //Carrega a lista de produto e categoria Atendimento
                        List<Produto> produtos = ProdutoFacade.buscarProdutos();
                        List<CategoriaAtendimento> catAtendimento = CategoriaAtendimentoFacade.buscarCategoriaAtendimento();
                        
                        //ADD OB NA REQUISIÇÃO
                        request.setAttribute("produtos", produtos);
                        request.setAttribute("categorias", catAtendimento);
                        
                        //ENVIA VIA FOWARD
                        rd = request.getRequestDispatcher("/novoAtendimento.jsp");
                        rd.forward(request, response);
                        
                        break;

                    case "mostrarAtendimento":
                        session = request.getSession();
                        user = (LoginBean)session.getAttribute("user");
                        int idu = user.getId();
                        String nomeu = user.getNome();
                        int ida = Integer.parseInt(request.getParameter("id"));     
                         //Carrega a lista de atendimentos para apresentar
                        List<Atendimento> atd = AtendimentoFacade.buscarAtendimentoPorIdAtendimento(idu, ida);

                        //ADD OBJ NA REQUISIÇÃO
                        request.setAttribute("atd", atd);
                        request.setAttribute("nomeu", nomeu);

                        //redireciona
                        rd = getServletContext().getRequestDispatcher("/verAtendimento.jsp");
                        rd.forward(request, response);

                        break;
                        
                    case "mostrarPortalCliente":
                        session = request.getSession();
                        user = (LoginBean)session.getAttribute("user");
                        int id = user.getId();

                        //Carrega a lista de atendimentos para apresentar
                        List<Atendimento> atendimentos = AtendimentoFacade.buscarAtendimentoPorCliente(id);

                        //ADD OBJ NA REQUISIÇÃO
                        request.setAttribute("atendimentos", atendimentos);

                        //redireciona
                        rd = getServletContext().getRequestDispatcher("/portalCliente.jsp");
                        rd.forward(request, response);

                        break;
                    
                    case "mostrarPortalGerente":
                        //Carrega quantidade de atendimentos
                        int qntAtendimentosTotal = AtendimentoFacade.getQuantidadeAtendimentosTodos();
                        int qntAtendimentosAbertos = AtendimentoFacade.getQuantidadeAtendimentosAbertos();
                        
                        //ADD na requisição
                        request.setAttribute("qntAtendimentosTotal", qntAtendimentosTotal);
                        request.setAttribute("qntAtendimentosAbertos", qntAtendimentosAbertos);
                        
                        //Carrega a lista de categorias para apresentar
                        List<CategoriaAtendimento> categorias = CategoriaAtendimentoFacade.buscarCategoriaAtendimento();
                        List<CategoriaAtendimento> categoriasAtendimento = AtendimentoFacade.getAtendimentosByCategoria(categorias);

                        //ADD OBJ NA REQUISIÇÃO
                        request.setAttribute("categoriasAtendimento", categoriasAtendimento);

                        //redireciona
                        rd = getServletContext().getRequestDispatcher("/portalGerente.jsp");
                        rd.forward(request, response);
                        break;
                    
                    case "mostrarAtendimentosGerente":
                        //Carrega a lista de atendimentos para apresentar
                        atendimentos = AtendimentoFacade.buscarTudo();

                        //ADD OBJ NA REQUISIÇÃO
                        request.setAttribute("atendimentos", atendimentos);

                        //redireciona
                        rd = getServletContext().getRequestDispatcher("/atendimentosGerente.jsp");
                        rd.forward(request, response);

                        break;
                        
                    case "removeAtendimento":
                        ida = Integer.parseInt(request.getParameter("ida"));

                        //remove atendimento
                        AtendimentoFacade.removerAtendimento(ida);

                         //redireciona
                        request.setAttribute("info", " Atendimento removido com sucesso!");
                        request.setAttribute("page", "portalCliente.jsp");
                        rd = getServletContext().getRequestDispatcher("/AtendimentoServlet?action=mostrarPortalCliente");
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
