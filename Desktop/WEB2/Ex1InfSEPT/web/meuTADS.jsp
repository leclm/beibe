<%-- 
    Document   : meuTADS
    Created on : 27 de jun. de 2022, 21:09:48
    Author     : Clau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
      
        <title align="center">Meu TADS</title>
    </head>
    <body>
        <div class="container" align="center" >
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
              <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <%--Imagem do Cabeçalho--%> 
                <img src="img/TADS-UFPR-SEPT.png" class="bi me-2" width="500" height="150" alt="SEPT UFPR"> 
                <span class="fs-4" >---------------------------  TADS  ---------------------------
                    <br/>Tecnologia em Análise e Desenvolvimento de Sistemas</span>
              </a>
              
            </header>
          </div>
        
        <%-- Tabela com Nome e Rede social--%> 
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Nome</th>
                <th scope="col">Rede Social</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Claudia Bastchen</td>
                <td><a href='https://www.youtube.com/c/CursoemV%C3%ADdeo/playlists'>YouTube</a></td>
              </tr>
              <tr>
                <td>Érica Riera</td>
                <td><a href='https://pt-br.facebook.com/'>Facebook</a></td>
              </tr>
              <tr>
                <td>Jackson Mardi</td>
                <td><a href='https://www.instagram.com/'>Instagran</a></td>
              </tr>
              <tr>
                <td>Nicolle da Silva Costa</td>
                <td><a href='https://www.vagalume.com.br/browse/style/sertanejo.html'>Vagalume</a></td>
              </tr>
              <tr>
                <td>Letícia das Chagas Lima</td>
                <td><a href='https://www.maquiadoro.com.br/maquiagem'>Maquiagens</a></td>
              </tr>
              <tr>
                <td>Luis Miguel Ismael Ferreira</td>
                <td><a href='https://www.webmotors.com.br/'>WebMotors</a></td>
              </tr>
              
            </tbody> 
          </table>
        
        <%-- Link voltar para página Servlet--%> 
        <a href='http://localhost:8080/Ex1InfSEPT/MinhaServlet' class="btn btn-light">Voltar</a>
    </body>
</html>
