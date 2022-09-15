<%-- 
    Document   : index
    Created on : 8 de set de 2022, 13:55:28
    Author     : lelim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.beibe.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--Validar se usuário está logado--%>
<c:if test="${sessionScope.user == null}" >
    <c:redirect url="index.jsp">
        <c:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
    </c:redirect>
</c:if>
<c:if test="${ sessionScope.user != null }" >
    <c:if test="${ sessionScope.user.tipo != 'funcionario' }" >
        <c:redirect url="index.jsp">
            <c:param name="msg" value="Usuário não possui permissão para acessar essa página."/>
        </c:redirect>
    </c:if>
</c:if>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Atendimentos
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
  </head>

  <body>
    <!-- Cabeçalho da página -->
    <jsp:include page="headerFuncionario.jsp" />

    <!-- Corpo da página -->
    <main class="container">
      <jsp:useBean id="atd" class="com.ufpr.tads.beibe.beans.Atendimento" scope="request" />
      <h2 class="mb-4">
        Atendimento [ID#${atd.id}]
      </h2>

      <!-- Dados do atendimento -->
      <form action="FuncionarioServlet?action=salvarAtendimento&ida=<c:out value="${atd.id}"/>&idu=<c:out value="${user.id}"/>" method="POST">
        <div class="form-group form-inline row ml-1">
          <p class="font-weight-bold mr-1">ID Usuário:</p>
          <p>${user.id}</p>
        </div>
        <div class="form-group form-inline row ml-1">
          <p class="font-weight-bold mr-1">Nome Usuário: </p>
          <p>${user.nome}</p>
        </div>
        <div class="form-group form-inline row ml-1">
          <p class="font-weight-bold mr-1">Produto: </p>
          <p>${atd.produto.nome}</p>
        </div>
        <div class="form-group row">
          <label for="status" class="col-2 col-form-label font-weight-bold">Status:</label>
          <div class="col-6">
            <select id="status" class="form-control" name="status">
              <option value="1">Aberto</option>
              <option value="2">Encerrado</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="font-weight-bold mr-1" for="solucao">Solução:</label>
          <textarea id="solucao" class="form-control" name="solucao" rows="4" placeholder="Digite uma mensagem para a solução do problema.">${produto.descricao}</textarea>
        </div>
        <button type="submit" class="btn btn-primary float-left w-25 mt-4">
          <i class="far fa-save"></i>
          Salvar Alterações
        </button>
      </form>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
    <jsp:include page="footer.jsp" />
  </body>
</html>