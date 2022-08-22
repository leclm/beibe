/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Clau
 */
@WebServlet(name = "MinhaServlet", urlPatterns = {"/MinhaServlet"})
public class MinhaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TesteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<font color='blue' face='Verdana'><h1>"
                    + "SEPT - SETOR DE EDUCAÇÃO PROFISSIONAL E TECNOLÓGICA</h1></font>");
            out.println("<h4>Endereço: Rua Dr. Alcides Vieira Arcoverde, 1225 "
                    + "CEP: 81520-260 - Jardim das Américas - Curitiba (PR) - Brasil</h4>");
            out.println("<br/>");
            
            /*Inicio da tabela*/
            out.println("<table  align='center' border='3'>");
                /* TR = Linhas da tabela*/
                out.println("<tr>");
                    /* TH = Cabeçalho da tabela*/
                    out.println("<th bgcolor='blue'><font color='white'>Curso</font></th>");
                    out.println("<th bgcolor='blue'><font color='white'>Página</font></th>");
                out.println("</tr>");
                
                /* TD = Dados da tabela*/ 
                /* Cursos Técnicos*/ 

                out.println("<tr>");
                    out.println("<td>TACS - Técnico em Agente Comunitário de Saúde</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/agentesaude/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>"); 
                
                out.println("<tr>");
                    /* Cursos Superiores*/ 
                    out.println("<td>TADS - Tecnologia em Análise e Desenvolvimento de Sistemas</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/analisesistemas/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                   
                out.println("<tr>");
                    out.println("<td>TCI - Tecnologia em Comunicação Institucional</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/comunicacaoinstitucional/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TGP - Tecnologia em Gestão Pública</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/gestaopublica/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TGQ - Tecnologia em Gestão da Qualidade</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/gestaoqualidade/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TL - Tecnologia em Luteria</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/luteria/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TNI - Tecnologia em Negócios Imobiliários</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/negociosimobiliarios/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TPC - Tecnologia em Produção Cênica</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/producaocenica/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>TPG - Técnico em Petróleo e Gás</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/petroleogas/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");   
                
                out.println("<tr>");
                    out.println("<td>TS - Tecnologia em Secretariado</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/secretariado/sobre-o-curso/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>EES - Especialização em Engenharia de Software</td>");
                    out.println("<td><a href='http://www.engenhariadesoftware.ufpr.br:28080/engenhariadesoftware/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    /*Pós-Graduação Lato Sensu*/
                    out.println("<td>EIAA - Especialização em Inteligência Artificial Aplicada</td>");
                    out.println("<td><a href='http://www.iaa.ufpr.br/'>Sobre o Curso</a></td>");
                out.println("</tr>");
                
                out.println("<tr>");
                    out.println("<td>MBA em Mercado Imobiliário</td>");
                    out.println("<td><a href='http://www.sept.ufpr.br/portal/blog/arquivos/principal/mba-negocios-imobiliarios-2020'>Sobre o Curso</a></td>");
                out.println("</tr>");
                    
                out.println("<tr>");
                    /*Pós-Graduação Stricto Sensu*/ 
                    out.println("<td>PGB - Pós-Graduação em Bioinformática</td>");
                    out.println("<td><a href='http://www.bioinfo.ufpr.br/'>Sobre o Curso</a></td>");
                out.println("</tr>");
            
            out.println("</table>");
                
             /* Fim da tabela  */
             
            out.println("<br/>");
            /* Link para página JSP */
            out.println("<a href='http://localhost:8080/Ex1InfSEPT/meuTADS.jsp'><h2>Meu TADS</h2></a>");
            out.println("<br/>"); 
            
            out.println("</body>");
            out.println("</html>");
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
