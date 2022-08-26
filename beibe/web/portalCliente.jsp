<%-- 
    Document   : portalCliente
    Created on : 21 de ago de 2022, 21:56:41
    Author     : grupo2
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    SAC - Sistema de Atendimento ao Cliente :: Trabalho Web 2 - Protótipo
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
            <a class="nav-link active" href="portalCliente.jsp">Meus Atendimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="dadosCliente.jsp">Meus Dados</a>
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
    <h2 class="mb-4">
      Meus Atendimentos
    </h2>

    <!-- Botão para abertura de novo atendimento -->
    <a href="menuAtendimentos.html" class="btn btn-lg btn-primary">
      <i class="fa fa-plus"></i>
      Solicitar Atendimento
    </a>

    <!-- Tabela com atendimentos em aberto -->
    <div class="mt-5">
      <h3 class="mb-3 h4">Atendimentos em aberto</h3>
      <table class="table table-hover">
        <thead class="c-thead">
          <tr class="text-center">
            <th scope="col">Ocorrência</th>
            <th scope="col">Produto</th>
            <th scope="col">Categoria</th>
            <th scope="col">Data de Criação</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        <tbody>
          <tr class="c-clickable text-center table-danger" data-href="verAtendimento.html">
            <th scope="row">000001</th>
            <td>Sérum Antirugas La Rosé</td>
            <td>Outros</td>
            <td>10-jun-2022</td>
            <td><span class="badge badge-sm badge-danger c-status">Contestado</span></td>

          </tr>
          <tr class="c-clickable text-center" data-href="verAtendimento.html">
            <th scope="row">000008</th>
            <td>Batom liquido Matte VivaLaVida (NUDE)</td>
            <td>Produto não recebido</td>
            <td>02-jul-2022</td>
            <td><span class="badge badge-sm badge-primary c-status">Recebido</span></td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- Tabela com atendimentos encerrados -->
    <div class="mt-5">
      <h3 class="h4">Atendimentos encerrados</h3>
      <table class="table table-hover">
        <thead class="c-thead">
          <tr>
            <th scope="col" class="text-center">Ocorrência</th>
            <th scope="col">Produto</th>
            <th scope="col" class="text-center">Categoria</th>
            <th scope="col" class="text-center">Data de Criação</th>
            <th scope="col" class="text-center">Status</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th colspan="5" class="py-3 h5 text-center">Nenhum atendimento encerrado</th>
          </tr>
        </tbody>
      </table>
    </div>
  </main>

  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/scripts.js"></script>
</body>
</html>