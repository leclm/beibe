<%-- 
    Document   : novoAtendimento
    Created on : 8 de set de 2022, 14:36:48
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      SAC - Sistema de Atendimento ao Cliente :: Trabalho Web 2
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
  </head>

  <body>


    <!-- Cabeçalho da página -->
    <header class="container-fluid bg-info mb-4">
      <nav class="navbar navbar-expand-lg navbar-light" role="navigation">
        <a class="navbar-brand" href="index.jsp">
          <img src="./assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
          <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
        </a>        <div class="container">
          <ul class="navbar-nav text-white">
            <li class="nav-item">
              <a class="nav-link" href="portalCliente.jsp">Meus Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="UsuarioServlet?action=mostrarCliente">Meus Dados</a>
            </li>
          </ul>
        </div>
        <div class="form-inline">
          <a href="LogoutServlet" class="alert-link text-white my-2 my-sm-0">
            <i class="fas fa-power-off"></i><br>
            Sair
          </a>
        </div>
      </nav>
    </header>
    <!-- Corpo da página -->
    <main class="container">
      <jsp:useBean id="atendimento" class="com.ufpr.tads.beibe.beans.Atendimento" scope="request" />
      <h2 class="mb-4">
        Novo Atendimento
      </h2>

      <!-- Formulário para abertura de atendimento -->
      <form action="AtendimentoServlet?action=novoAtendimento" method="POST">
        <div class="row">
          <div class="col-12 col-md-6">
            <div class="form-group">
              <label for="produtoNome">Nome do produto:</label>
              <select  id="produtoNome" class="form-control" name="produto">
                <option value="">Selecione</option>
                <c:forEach items="${produtos}" var="prd">
                    <option value="${prd.id}"<c:if test="${atendimento.produto == prd.id}">selected</c:if>>${prd.nome}</option>
                </c:forEach>
              </select>
            </div>

          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-8">
            <div class="form-group">
              <label for="atendimentoCategoria">Motivo do atendimento:</label>
              <select id="atendimentoCategoria" class="form-control" name="categoria">
                <option value="">Selecione</option>
                <c:forEach items="${categorias}" var="cat">
                    <option value="${cat.id}"<c:if test="${atendimento.categoriaAtendimento == cat.id}">selected</c:if>>${cat.nome}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group">
              <label for="atendimentoDesc">Descrição:</label>
              <textarea id="atendimentoDesc" class="form-control" rows="5" name="descricao"></textarea>
            </div>
          </div>
        </div>
        <button type="submit" class="btn btn-lg btn-primary w-25">
          <i class="fas fa-paper-plane"></i>
          Enviar
        </button>
      </form>
    </main>


    <jsp:include page="footer.jsp" />
</body>


</html>
