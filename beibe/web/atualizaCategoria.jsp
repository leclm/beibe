<%-- 
    Document   : index
    Created on : 8 de set de 2022, 13:55:28
    Author     : lelim
--%>

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
      Atualiza Categoria
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
        <a class="navbar-brand" href="funcionario.jsp">
          <img src="./assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
          <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
        </a>
        <div class="container">
          <ul class="navbar-nav text-white">
            <li class="nav-item">
              <a class="nav-link" href="FuncionarioServlet?action=mostrarPortalFuncionario">Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="CategoriaProdutoServlet?action=listarCategoriaProduto">Categorias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ProdutoServlet?action=listarProduto">Produtos</a>
            </li>
          </ul>
        </div>
        <div class="form-inline">
          <a href="./index.jsp" class="alert-link text-white my-2 my-sm-0">
            <i class="fas fa-power-off"></i><br>
            Sair
          </a>
        </div>
      </nav>
    </header>
    
    <!-- Corpo da página -->
    <main class="container">
      <jsp:useBean id="categoria" class="com.ufpr.tads.beibe.beans.CategoriaProduto" scope="request" />
      <h2 class="mb-4">
        Nova Categoria
      </h2>

      <!-- Formulário para criação de categoria -->
      <form action="CategoriaProdutoServlet?action=salvarAlteraCategoriaProduto&id=${categoria.id}" method="POST">
        <div class="row">
          <div class="col-12 jsutify-content-between">
            <button type="submit" class="btn btn-primary float-right w-25">
              <i class="far fa-save"></i>
              Salvar
            </button>
            <h3 class="mb-3 h4">Dados Cadastrais</h3>
          </div>
          <div class="col-12 col-md-8">
            <div class="form-group">
              <label for="categoria-nome">Nome da categoria:</label>
              <input type="text" id="nome" class="form-control" name="nome"
                value="${categoria.nome}" />
            </div>
          </div>
        </div>
      </form>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
  </body>
</html>
