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
      SAC - Atendimentos
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
              <a class="nav-link" href="atendimentos.jsp">Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="categorias.jsp">Categorias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="ProdutoServlet?action=listarProduto">Produtos</a>
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
      <h2 class="mb-4">
      Atendimento #[ID do atendimento]
      </h2>

      <!-- Dados do atendimento -->
      <form action="atendimentos.jsp" method="POST">
        <button type="submit" class="btn btn-primary float-right w-25">
          <i class="far fa-save"></i>
          Salvar Alterações
        </button>
        <div class="form-group row">
          <label for="atendimento-id" class="col-2 col-form-label">Atendimento:</label>
          <div class="col-10">
            <input type="text" id="atendimento-id" class="form-control-plaintext" readonly value="#100123" />
          </div>
        </div>
        <div class="form-group row">
          <label for="atendimento-cliente" class="col-2 col-form-label">Cliente:</label>
          <div class="col-10">
            <input type="text" id="atendimento-cliente" class="form-control-plaintext" readonly value="#666 (Josnei)" />
          </div>
        </div>
        <div class="form-group row">
          <label for="atendimento-produto" class="col-2 col-form-label">Produto:</label>
          <div class="col-10">
            <input type="text" id="atendimento-produto" class="form-control-plaintext" readonly
              value="#50004 (Batom Cacatua Raivosa)" />
          </div>
        </div>
        <div class="form-group row">
          <label for="atendimento-tipo" class="col-2 col-form-label">Tipo do atendimento:</label>
          <div class="col-6">
            <select id="atendimento-tipo" class="form-control" name="tipo">
              <option>Selecione...</option>
              <option value="1">Financeiro</option>
              <option value="2" selected>Produto com defeito</option>
              <option value="3">Produto não recebido</option>
              <option value="4">Sugestões / Reclamações</option>
              <option value="0">Outros</option>
            </select>
          </div>
        </div>
        <div class="form-group row">
          <label for="atendimento-status" class="col-2 col-form-label">Status:</label>
          <div class="col-6">
            <select id="atendimento-status" class="form-control" name="status">
              <option value="1">Recebido</option>
              <option value="2">Sob Análise</option>
              <option value="3" selected>Contestado</option>
              <option value="4">Encerrado</option>
            </select>
          </div>
        </div>
      </form>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
  </body>
</html>
