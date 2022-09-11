<%-- 
    Document   : portalCliente
    Created on : 21 de ago de 2022, 21:56:41
    Author     : grupo2
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.beibe.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      </a>
      <div class="container">
                
        <ul class="navbar-nav text-white">
          <li class="nav-item">
            <a class="nav-link active" href="AtendimentoServlet?action=mostrarPortalCliente">Meus Atendimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="UsuarioServlet?action=mostrarCliente">Meus Dados</a>
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
        <c:if test="${requestScope.info != null || param.info != null}" >
                      <div class="alert alert-success alert-dismissible fade show">
                          <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                          <span>${requestScope.info == null ? param.info : requestScope.info}</span>
                      </div>
        </c:if>
    <h2 class="mb-4">
      Meus Atendimentos
    </h2>

    <!-- Botão para abertura de novo atendimento -->
    <a href="AtendimentoServlet?action=mostrarNovoAtendimento" class="btn btn-lg btn-primary">
      <i class="fa fa-plus"></i>
      Solicitar Atendimento
    </a>

    <!-- Tabela com atendimentos em aberto -->
    <div class="mt-5">
      <table class="table table-hover">
        <thead class="c-thead">
          <tr class="text-center">
            <th scope="col">Id do Atendimento</th>
            <th scope="col">Produto</th>
            <th scope="col">Categoria</th>
            <th scope="col">Data de Criação</th>
            <th scope="col">Status</th>
            <th scope="col">Visualizar</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${requestScope.atendimentos}" var="a" >
          <tr class="c-clickable text-center" data-href="AtendimentoServlet?action=mostrarAtendimento&id=<c:out value="${a.id}"/>">
            <th scope="row"><c:out value="${a.id}"/></th>
            <td><c:out value="${a.produto.nome}"/></td>
            <td><c:out value="${a.categoriaAtendimento.nome}"/></td>
            <td><fmt:formatDate value="${a.dataHr}" pattern="dd/MM/yyyy HH:mm"/></td>
            <td><c:out value="${a.situacaoAtendimento.nome}"/></td>
            <td><a href="AtendimentoServlet?action=mostrarAtendimento&id=<c:out value="${a.id}"/>">Ver</td>
            <!-- comment<td><span class="badge badge-sm badge-danger c-status">Contestado</span></td> --> 

          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </main>

  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/scripts.js"></script>
</body>
</html>