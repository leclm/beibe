<%-- 
    Document   : portalGerente
    Created on : 14 de set de 2022, 11:40:18
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.beibe.beans.LoginBean"%>
<%--Validar se usuário está logado--%>
<c:if test="${sessionScope.user == null}" >
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
    </c:redirect>
</c:if> 
<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>
    SAC - Sistema de Atendimento ao Cliente :: Trabalho Web 2 - Protótipo
  </title>
  <link rel="stylesheet" href="./css/bootstrap.min.css" />
  <link rel="stylesheet" href="./css/fontawesome.min.css" />
  <link rel="stylesheet" href="./css/styles.css" />
  <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
</head>

<body>

  <!-- Cabeçalho da página -->
  <jsp:include page="headerGerente.jsp" />

  <!-- Corpo da página -->
  <main class="container">
    <h2 class="mb-4">
      Bem-vindo(a), <strong>${sessionScope.user.nome}</strong>
    </h2>
    <div class="card-columns">
        <div class="card-link">
          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Atendimento(s) Vencido(s)</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-thumbs-down"></i>
                      </p>
                  </div>
                  <a href="atendimentos.html" class="stretched-link h-0"></a>
              </div>
          </div>
          
          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Atendimento(s) em Aberto</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-history"></i>
                      </p>
                  </div>
                  <a href="atendimentos.html" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Relatório de Funcionários</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-file-pdf"></i>
                      </p>
                  </div>
                  <a href="#" onclick="alert('Recurso indisponível!')" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Relatório de Produtos Mais Reclamados</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-file-pdf"></i>
                      </p>
                  </div>
                  <a href="#" onclick="alert('Recurso indisponível!')" class="stretched-link h-0"></a>
              </div>
          </div>
          
          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Relatório de Atendimentos Abertos</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-file-pdf"></i>
                      </p>
                  </div>
                  <a href="#" onclick="alert('Recurso indisponível!')" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Relatório de Reclamações</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-file-pdf"></i>
                      </p>
                  </div>
                  <a href="#" onclick="alert('Recurso indisponível!')" class="stretched-link h-0"></a>
              </div>
          </div>
        </div>
      </div>
  </main>

   <jsp:include page="footer.jsp" />
</body>

</html>