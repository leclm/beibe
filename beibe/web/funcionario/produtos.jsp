<%-- 
    Document   : index
    Created on : 8 de set de 2022, 13:55:28
    Author     : lelim
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Cadastro Produtos
    </title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/fontawesome.min.css" />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">
  </head>
  
  <body>
    <!-- Cabeçalho da página -->
    <header class="container-fluid bg-info mb-4">
      <nav class="navbar navbar-expand-lg navbar-light" role="navigation">
        <a class="navbar-brand" href="funcionario.jsp">
          <img src="../assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
          <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
        </a>
        <div class="container">
          <ul class="navbar-nav text-white">
            <li class="nav-item">
              <a class="nav-link" href="funcionario.jsp">Início</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="atendimentos.jsp">Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="categorias.jsp">Categorias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="/ProdutoServlet?action=listarProduto">Produtos</a>
            </li>
          </ul>
        </div>
        <div class="form-inline">
          <a href="../index.jsp" class="alert-link text-white my-2 my-sm-0">
            <i class="fas fa-power-off"></i><br>
            Sair
          </a>
        </div>
      </nav>
    </header>
    
    <!-- Corpo da página -->
    <main class="container">
      <h2 class="mb-4">
        Produtos
      </h2>

      <!-- Botão para abertura de novo atendimento -->
      <a href="/ProdutoServlet?action=cadastroProduto" class="btn btn-lg btn-primary">
        <i class="fa fa-plus"></i>
        Criar Novo Produto
      </a>

      <!-- Tabela com atendimentos em aberto -->
      <div class="mt-5">
        <table id="login-table" class="table table-bordered mb-0">
            <div class="table-group">
                <div class="row">
                    <div class="col-md-6">
                        <thead for="categoria">
                            <tr>
                                <th scope="col" class="table-dark align-middle">Produto</th>
                                <th scope="col" class="table-light align-middle">Categoria</th>
                                <th scope="col" class="table-dark align-middle">Visualizar</th>
                                <th scope="col" class="table-light align-middle">Alterar</th>
                                <th scope="col" class="table-dark align-middle">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${produtos}" var="produto">
                                <tr>
                                    <td>${produto.nome}</td>
                                    <td>${produto.tipoProduto.descricao}</td>
                                    <td><a href="${pageContext.request.contextPath}/ProdutoServlet?acao=visualizar&id=${produto.id}" class="btn btn-info" style="width: 100%;">Visualizar</button></td>
                                    <td><a href="${pageContext.request.contextPath}/ProdutoServlet?acao=alterar&id=${produto.id}" class="btn btn-info" style="width: 100%;">Alterar</a></td>
                                    <td><button type="button" class="btn btn-danger" onclick="removerProduto(${produto.id})" style="width: 100%;">Excluir</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </div>
                </div>
            </div>
        </table>
      </div>
    </main>

    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>
