/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 *
 * @author Clau
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

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
        
        HttpSession lista = request.getSession();
        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>)lista.getAttribute("lista");
        
        if(listaUsuarios == null){
            listaUsuarios = new ArrayList<>();
            listaUsuarios.add(new Usuario("admin","admin","admin"));
            listaUsuarios.add(new Usuario("teste","teste","teste"));
        }
        
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        getServletContext().getRequestDispatcher("/ServletHTML/header.html").include(request, response);
        
        out.println("<br/>");
        out.println("<br/>");
        out.println("<h3>Usuários cadastrados</h3>");
        out.println("<table class=\"table table-hover\">");
                     out.println("<thead>");
                         out.println("<tr>");
                             out.println("<th>Nome</th>");
                             out.println("<th>Usuario</th>");
                             out.println("<th>Senha</th>");
                         out.println("</tr>");
                     out.println("</thead>");
                     out.println("<tbody>");
        for(Usuario uwu : listaUsuarios){
            out.println("<tr>");
            out.println("<td>" + uwu.getNome()+ "</td>");
            out.println("<td>" + uwu.getId()+ "</td>");
            out.println("<td>" + uwu.getSenha()+ "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        
        lista.setAttribute("lista", listaUsuarios);
        getServletContext().getRequestDispatcher("/ServletHTML/footer.html");
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
