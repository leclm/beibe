<%-- 
    Document   : index
    Created on : 10 de set de 2022, 17:55:28
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
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Atualiza Produto
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
      <jsp:useBean id="produto" class="com.ufpr.tads.beibe.beans.Produto" scope="request" />
      <h2 class="mb-4">
        Alterar Produto
      </h2>

 

      <!-- Formulário para alteração de produto -->
      <form action="ProdutoServlet?action=salvarAlteraProduto&id=${produto.id}" method="POST">
        <div class="row">
          <div class="col-12 jsutify-content-between">
            <button type="submit" class="btn btn-primary float-right w-25">
              <i class="far fa-save"></i>
              Salvar
            </button>
            <h3 class="mb-3 h4">Dados Cadastrais</h3>
          </div>
          <div class="col-12 col-md-6">
            <div class="form-group">
              <label for="nome">Nome do produto:</label>
              <input type="text" id="nome" class="form-control" name="nome"
                value="${produto.nome}" minlengh="5" maxlengh="32" />
            </div>
            <div class="form-group">
              <label for="descricao">Descrição:</label>
              <textarea id="descricao" class="form-control" name="descricao" rows="4">${produto.descricao}</textarea>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="form-group">
              <label for="idcategoria">Categoria:</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-puzzle-piece"></i>
                  </span>
                </div>
                <select name="idcategoria" id="idcategoria" class="form-control" ${(requestScope.permiteAlterar || requestScope.permiteAlterar == null)  ? '' : 'disabled="disabled"'}>
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.id}" ${param.categoria == categoria.nome ? 'selected="true"' : '' }>${categoria.nome}</option>
                    </c:forEach>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label for="peso">Peso bruto:</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-weight"></i>
                  </span>
                </div>
                <input type="number" id="peso" class="form-control" name="peso" value="${produto.peso}" />
              </div>
            </div>
          </div>
        </div>
      </form>
    </main>

 

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
  </body>
</html>