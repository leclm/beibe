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
      SAC - Categorias
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
  </head>
  <script type="text/javascript">
      function removerProduto(id) {
          excluir = confirm('Tem certeza que deseja excluir a categoria?');
          if (excluir) {
              document.location.href = "CategoriaProdutoServlet?action=removerCategoriaProduto&id=" + id;
          }
      }
  </script>

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
      <h2 class="mb-4">
        Categorias de Produtos
      </h2>

      <!-- Botão para abertura de novo atendimento -->
      <a href="CategoriaProdutoServlet?action=cadastroCategoriaProduto" class="btn btn-lg btn-primary">
        <i class="fa fa-plus"></i>
        Criar Nova Categoria
      </a>

      <!-- Tabela com atendimentos em aberto -->
      <div class="mt-5">
        <table id="login-table" class="table table-hover mb-0">
          <div class="table-group">
            <div class="row">
              <div class="col-md-6">
                <thead for="categoria" class="c-thead">
                  <tr>
                    <th scope="col" class="table-dark align-middle text-center">ID</th>
                    <th scope="col" class="table-dark align-middle text-center">Nome</th>
                    <th scope="col" class="table-dark align-middle text-center"></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${listCategorias}" var="categoria">
                      <tr class="text-center">
                        <td>${categoria.id}</td>
                        <td>${categoria.nome}</td>
                        <td>
                          <a href="CategoriaProdutoServlet?action=alteraCategoriaProduto&id=${categoria.id}&categoria=${categoria.nome}" class="btn btn-sm btn-info" title="Editar">
                            <i class="fas fa-edit"></i>
                          </a>
                          <button type="button" class="btn btn-sm btn-danger" onclick="removerProduto(${categoria.id})" title="Excluir">
                            <i class="fas fa-trash-alt"></i>
                          </button>
                        </td>
                      </tr>
                  </c:forEach>
                </tbody>
              </div>
            </div>
          </div>
        </table>
      </div>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
  </body>
</html>
