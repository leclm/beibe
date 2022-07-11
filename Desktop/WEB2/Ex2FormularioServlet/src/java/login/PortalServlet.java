/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login;

import classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

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
        
        try (PrintWriter out = response.getWriter())
        {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            
            //Usando Constructor
            Usuario usuario1 = new Usuario("Claudia", "Claudia35", "minhasenha");
            
            //Usando Encapsulamento
            Usuario usuario2 = new Usuario();
            usuario2.setNome("root");
            usuario2.setId("root");
            usuario2.setSenha("root");
            
            //classe nome objeto   novo usuário  //Usando Constructor
            Usuario usuario3 = new Usuario("adm", "adm", "adm");
            
            usuarios.add(usuario1); //id 0
            usuarios.add(usuario2); //id 1
            usuarios.add(usuario3);  //id 2
        
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/PortalServlet/header.html").include(request, response); 
        
        out.println("<br/>");
        out.println("<br/>");
        out.println("<table class=\"table table-hover\">");
                     out.println("<thead class=\"thead-dark\">");
                         out.println("<tr>");
                             out.println("<th>Nome</th>");
                             out.println("<th>Usuario</th>");
                             out.println("<th>Senha</th>");
                         out.println("</tr>");
                     out.println("</thead>");
            
            for(Usuario usuario : usuarios){
                out.println("<tr>");
                    out.println("<td>");
                        out.println(usuario.getNome());
                    out.println("</td>");
                    
                    out.println("<td>");
                        out.println(usuario.getId());
                    out.println("</td>");
                    
                    out.println("<td>");
                        out.println(usuario.getSenha());
                    out.println("</td>");
                out.println("</tr>");
            }                        
            out.println("</table>");
            
                     out.println("<tbody>");
                     
        
        out.println("</tbody>");
        out.println("</table>");
        
        getServletContext().getRequestDispatcher("/PortalServlet/footer.html");
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
