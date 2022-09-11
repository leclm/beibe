/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ufpr.tads.beibe.servlet;

import com.ufpr.tads.beibe.beans.Cidade;
import com.ufpr.tads.beibe.beans.Estado;
import com.ufpr.tads.beibe.beans.LoginBean;
import com.ufpr.tads.beibe.beans.Usuario;
import com.ufpr.tads.beibe.dao.CidadeDAO;
import com.ufpr.tads.beibe.dao.EstadoDAO;
import com.ufpr.tads.beibe.exception.FacadeException;
import com.ufpr.tads.beibe.facade.UsuarioFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author grupo2
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
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        try{      
            if(action==null){
                //redireciona
                response.sendRedirect("LogoutServlet");
            } else{
                switch (action) {

                    case "autocadastro":
                        //Valores pegos do formulario, já no formato para BD
                        String cpf = request.getParameter("cpf");
                        String nome = request.getParameter("nome");
                        String email = request.getParameter("email");
                        String telefone = request.getParameter("telefone");
                        String cep = request.getParameter("cep");
                        String rua = request.getParameter("rua");
                        int nr = Integer.parseInt(request.getParameter("numero"));
                        String complemento = request.getParameter("complemento");
                        String bairro = request.getParameter("bairro");
                        String cidade = request.getParameter("cidade");
                        String uf = request.getParameter("estado");
                        String senha = request.getParameter("senha");
                        //cria um novo objeto cliente
                        Usuario c = new Usuario();
                        //adiciona os valores a esse objeto
                        c.setCpf(cpf);
                        c.setNome(nome);
                        c.setEmail(email);
                        c.setTelefone(telefone);
                        c.setCep(cep);
                        c.setRua(rua);
                        c.setNr(nr);
                        c.setComplemento(complemento);
                        c.setBairro(bairro);
                        c.setCidade(cidade);
                        c.setUf(uf);
                        c.setSenha(senha);


                        //função para inserir no bd via Facade
                        UsuarioFacade.adicionarCliente(c);
                        //redireciona
                        response.sendRedirect("index.jsp");
                        break;  

                    case "mostrarCliente":
                        HttpSession session = request.getSession();
                        LoginBean user = (LoginBean)session.getAttribute("user");
                        int id = user.getId();
                        //BUSCA OBJETO NO BD via Facade
                        Usuario cliente = UsuarioFacade.buscaPorID(id);
                         //Carrega a lista de estados, para apresentar na Combo
                        List<Estado> estados = EstadoDAO.buscarTudo();
                        List<Cidade> cidades = CidadeDAO.buscarTudo();
                        //ADD OB NA REQUISIÇÃO
                        request.setAttribute("cliente", cliente);
                        request.setAttribute("estados", estados);
                        request.setAttribute("cidades", cidades);

                        //ENVIA VIA FOWARD
                        RequestDispatcher rd = request.getRequestDispatcher("/dadosCliente.jsp");
                        rd.forward(request, response);
                        break;

                    case "alterarCadastro":
                         //Valores pegos do formulario, já no formato para BD 
                        session = request.getSession();
                        user = (LoginBean)session.getAttribute("user");
                        id = user.getId();
                        cpf = request.getParameter("cpf");
                        nome = request.getParameter("nome");
                        telefone = request.getParameter("telefone");
                        email = request.getParameter("email");
                        cep = request.getParameter("cep");
                        rua = request.getParameter("rua");
                        nr = Integer.parseInt(request.getParameter("numero"));
                        complemento = request.getParameter("complemento");
                        bairro = request.getParameter("bairro");
                        cidade = request.getParameter("cidade");
                        uf = request.getParameter("estado");
                        senha = request.getParameter("senha");
                        String tipo = request.getParameter("tipo");


                        //cria um novo objeto cliente
                        Usuario u = new Usuario();
                        //adiciona os valores a esse objeto
                        u.setId(id);
                        u.setCpf(cpf);
                        u.setNome(nome);
                        u.setEmail(email);
                        u.setTelefone(telefone);
                        u.setCep(cep);
                        u.setRua(rua);
                        u.setNr(nr);
                        u.setComplemento(complemento);
                        u.setBairro(bairro);
                        u.setCidade(cidade);
                        u.setUf(uf);
                        u.setSenha(senha);
                        u.setTipo(tipo);


                      //função para atualizar no bd via Facade
                        UsuarioFacade.aterarUsuario(u);

                        //redireciona
                        request.setAttribute("info", " Usuário atualizado");
                        request.setAttribute("page", "/portalCliente.jsp");
                        rd = getServletContext().getRequestDispatcher("/portalCliente.jsp");
                        rd.forward(request, response);

                        break;


                    case "entrarCadastro":
                     //Carrega a lista de estados, para apresentar na Combo
                        estados = EstadoDAO.buscarTudo();
                        cidades = CidadeDAO.buscarTudo();
                        //ADD OB NA REQUISIÇÃO
                        request.setAttribute("estados", estados);
                        request.setAttribute("cidades", cidades);

                        //ENVIA VIA FOWARD
                        rd = request.getRequestDispatcher("/cadastroCliente.jsp");
                        rd.forward(request, response);
                        break;

                    default:
                        //redireciona
                        response.sendRedirect("LogoutServlet");

                } 
            } 
        } catch(FacadeException ex) {
            request.setAttribute("msg", " Falha de conexão com o Banco de Dados");
            request.setAttribute("page", "erro.jsp");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
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
