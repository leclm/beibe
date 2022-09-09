<%-- 
    Document   : index
    Created on : 8 de set de 2022, 13:55:28
    Author     : lelim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Atendimentos
    </title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/fontawesome.min.css" />
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="icon" type="image/x-icon" href="../assets/images/phone-solid.svg">
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
              <a class="nav-link active" href="atendimentos.jsp">Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="categorias.jsp">Categorias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="produtos.jsp">Produtos</a>
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
        Atendimentos
      </h2>

      <!-- Filtro de visualização de atendimentos -->
      <jsp:useBean id="dataBean" class="java.util.Date"/>
      <div class="mt-3">
        <div class="form-inline p-2">
          <label for="filtro-atendimentos">
            <i class="fas fa-filter"></i>
            <span class="mx-2">Visualizar:</span>
          </label>
          <select id="filtro-atendimentos" class="form-control">
            <option value="todos">Todos</option>
            <option value="abertos">Abertos</option>
            <option value="vencidos">Vencidos</option>
            <option value="fechados">Fechados</option>
          </select>
        </div>

        <!-- Tabela de atendimentos -->
        <table class="table table-hover">
          <thead class="c-thead">
            <tr class="text-center">
              <th scope="col">#</th>
              <th scope="col">Produto</th>
              <th scope="col">Categoria</th>
              <th scope="col">Data de Criação</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-warning c-status">Sob Análise</span></td>
            </tr>
            <tr class="c-clickable text-center table-danger" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-danger c-status">Contestado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-primary c-status">Recebido</span></td>
            </tr>
            <tr class="c-clickable text-center table-danger" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-danger c-status">Contestado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-warning c-status">Sob Análise</span></td>
            </tr>
            <tr class="c-clickable text-center table-danger" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-danger c-status">Contestado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-primary c-status">Recebido</span></td>
            </tr>
            <tr class="c-clickable text-center table-danger" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-danger c-status">Contestado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Shampoo Ass-Hair (para cachos ruivos)</td>
              <td>Produto não recebido</td>
              <td>15-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
            <tr class="c-clickable text-center" data-href="atualizaAtendimento.jsp">
              <th scope="row">100123</th>
              <td>Sabonete SOAP (aroma lavanda)</td>
              <td>Produto com defeito</td>
              <td>8-jul-2022</td>
              <td><span class="badge badge-sm badge-success c-status">Encerrado</span></td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
    
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>