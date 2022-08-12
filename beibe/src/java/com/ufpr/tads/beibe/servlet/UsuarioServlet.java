/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.facade.UsuarioFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nicol
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
        
        String action = request.getParameter("action");
       
        
        
        
        if(action==null || action.equals("list")){
           /* List<Cliente> clientes = ClientesFacade.listarTodos();
            request.setAttribute("listaClientes", clientes);
            RequestDispatcher rd = request.getRequestDispatcher("/clientesListar.jsp");
            rd.forward(request, response);*/
        } else{            
            switch (action) {

                /*case "show":
                    int id = Integer.parseInt(request.getParameter("id"));
                    //BUSCA OBJETO NO BD via Facade
                    Cliente cliente = ClientesFacade.buscaId(id);
                    //ADD OB NA REQUISIÇÃO
                    request.setAttribute("cliente", cliente);
                    //ENVIA VIA FOWARD
                    RequestDispatcher rd = request.getRequestDispatcher("/clientesVisualizar.jsp");
                    rd.forward(request, response);
                    break;

                case "formUpdate":
                    //PEGA O PARAMETRO PASSADO PELA PAGINA
                    id = Integer.parseInt(request.getParameter("id"));
                    //BUSCA OBJETO NO BD via Facade
                    cliente = ClientesFacade.buscaId(id);
                    //ADD OB NA REQUISIÇÃO
                    request.setAttribute("cliente", cliente);
                    //ENVIA VIA FOWARD
                    rd = request.getRequestDispatcher("/clientesAlterar.jsp");
                    rd.forward(request, response);
                    break;
                case "remove":
                    //PEGA O PARAMETRO PASSADO PELA PAGINA
                    id = Integer.parseInt(request.getParameter("id"));
                    //REMOVE OBJETO NO BD via Facade
                    ClientesFacade.remover(id);
                    //ENVIA VIA FOWARD
                    rd = request.getRequestDispatcher("/ClientesServlet?action=list");
                    rd.forward(request, response);
                    break;
                case "update":
                     //Valores pegos do formulario, já no formato para BD
                    id = Integer.parseInt(request.getParameter("cId"));
                    String cpf = request.getParameter("cCpf");
                    String nome = request.getParameter("cNome");
                    String email = request.getParameter("cEmail");
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date data=null;
                    try {
                     data = format.parse(request.getParameter("cData"));
                    } catch(Exception e) {
                        System.out.println("Data no formato errado");
                        e.printStackTrace();
                    }
                    String rua = request.getParameter("cRua");
                    int nr = Integer.parseInt(request.getParameter("cNumero"));
                    String cep = request.getParameter("cCep");
                    String cidade = request.getParameter("cCidade");
                    String uf = request.getParameter("cUf");
                    //cria um novo objeto cliente
                    Cliente c = new Cliente();
                    //adiciona os valores a esse objeto
                    c.setId(id);
                    c.setCpf(cpf);
                    c.setNome(nome);
                    c.setEmail(email);
                    c.setData(data);
                    c.setRua(rua);
                    c.setNr(nr);
                    c.setCep(cep);
                    c.setCidade(cidade);
                    c.setUf(uf);

                    //função para atualizar no bd via Facade
                    ClientesFacade.atualizarCliente(c);
                    //redireciona
                    response.sendRedirect("ClientesServlet");
                    break;

                case "formNew":
                    response.sendRedirect("clientesNovo.jsp");
                    break;
             */
             //Parte já pronta para teste------------------------------------------------------------------------
                case "newC":
                    //Valores pegos do formulario, já no formato para BD
                    String cpf = request.getParameter("cpf");
                    String nome = request.getParameter("nome");
                    String email = request.getParameter("email");
                    String telefone = request.getParameter("telefone");
                    String rua = request.getParameter("rua");
                    int nr = Integer.parseInt(request.getParameter("numero"));
                    String complemento = request.getParameter("complemento");
                    String cidade = request.getParameter("cidade");
                    String uf = request.getParameter("estado");
                    String senha = request.getParameter("senha1");
                    //cria um novo objeto cliente
                    Usuario c = new Usuario();
                    //adiciona os valores a esse objeto
                    c.setCpf(cpf);
                    c.setNome(nome);
                    c.setEmail(email);
                    c.setTelefone(telefone);
                    c.setRua(rua);
                    c.setNr(nr);
                    c.setComplemento(complemento);
                    c.setCidade(cidade);
                    c.setUf(uf);
                    c.setSenha(senha);
                    //função para inserir no bd via Facade
                    UsuarioFacade.adicionarCliente(c);
                    //redireciona
                    response.sendRedirect("index.jsp");
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
