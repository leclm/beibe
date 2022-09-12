<%-- 
    Document   : erro
    Created on : 11 de set de 2022, 23:00:07
    Author     : grupo2
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Sistema de Atendimento ao Cliente
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">

  </head>
  <body>
  <!-- Corpo da página -->
  <main class="container">
    <h2 class="mb-4">
      Página de Erro
    </h2>
        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center">Ocorreu um erro : </h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
              <p class="text-center">${pageContext.exception.message}</p>   
                ${pageContext.out.flush()}
                ${pageContext.exception.printStackTrace(pageContext.response.writer)}
               
                <p class="text-center">${requestScope.msg}</p>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="${requestScope.page}" class="text-info">Voltar</a>
            </div>
        </div>

  </main>


   
<jsp:include page="footer.jsp" />
  </body>
</html>
