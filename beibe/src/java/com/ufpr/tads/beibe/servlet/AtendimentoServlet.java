/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.Atendimento;
import com.ufpr.tads.beibe.beans.CategoriaAtendimento;
import com.ufpr.tads.beibe.beans.LoginBean;
import com.ufpr.tads.beibe.beans.Produto;
import com.ufpr.tads.beibe.dao.ProdutoDAO;
import com.ufpr.tads.beibe.facade.AtendimentoFacade;
import com.ufpr.tads.beibe.facade.CategoriaAtendimentoFacade;
import com.ufpr.tads.beibe.facade.ProdutoFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author nicol
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
              
        if(action==null || action.equals("list")){
           /* List<Cliente> clientes = ClientesFacade.listarTodos();
            request.setAttribute("listaClientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("/clientesListar.jsp");
            rd.forward(request, response);*/
        } else{            
            switch (action) {
   
                 case "novoAtendimento":
                    //Valores pegos do formulario, já no formato para BD 
                    HttpSession session = request.getSession();
                    LoginBean user = (LoginBean)session.getAttribute("user");
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
 /*
                 try ( PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                /*    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet apagar</title>");          
                    out.println("</head>");
                    out.println("<body>");
                    out.println(idu);
                    out.println(ida);
                    out.println("</body>");
                    out.println("</html>");
                } */
 
                break;
               
                
                
                case "mostrarPortalCliente":
                session = request.getSession();
                user = (LoginBean)session.getAttribute("user");
                id = user.getId();
                     
    
                 //Carrega a lista de atendimentos para apresentar
                List<Atendimento> atendimentos = AtendimentoFacade.buscarAtendimentoPorCliente(id);
                 
                  //ADD OBJ NA REQUISIÇÃO
                 request.setAttribute("atendimentos", atendimentos);
                 
                //redireciona
                rd = getServletContext().getRequestDispatcher("/portalCliente.jsp");
                rd.forward(request, response);
                break;
                
                
                case "removeAtendimento":
                 
                ida = Integer.parseInt(request.getParameter("ida"));
    
            
                 //remove atendimento
                 AtendimentoFacade.removerAtendimento(ida);
                 
                 //redireciona
                request.setAttribute("info", " Atendimento removido com sucesso!");
                request.setAttribute("page", "portalCliente.jsp");
                rd = getServletContext().getRequestDispatcher("/portalCliente.jsp");
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
