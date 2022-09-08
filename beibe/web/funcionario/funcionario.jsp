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
      SAC - Funcionário
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
              <a class="nav-link active" href="funcionario.jsp">Início</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="atendimentos.jsp">Atendimentos</a>
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
        Bem-vindo(a), <strong>[Funcionário]</strong>
      </h2>
      <div class="card-columns">
        <div class="card-link">
          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Atendimento(s) em Aberto</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-history"></i>
                      </p>
                  </div>
                  <a href="atendimentos.jsp" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Atendimento(s) Vencido(s)</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-thumbs-down"></i>
                      </p>
                  </div>
                  <a href="atendimentos.jsp" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Criar Nova Categoria</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-plus-square"></i>
                      </p>
                  </div>
                  <a href="cadastroCategoria.jsp" class="stretched-link h-0"></a>
              </div>
          </div>

          <div class="text-light">
              <div class="card bg-info" style="max-width: 18rem;">
                  <div class="card-header">Criar Novo Produto</div>
                  <div class="card-body text-center">
                      <p class="card-text display-3">
                          <i class="fa fa-plus-square"></i>
                      </p>
                  </div>
                  <a href="cadastroProduto.jsp" class="stretched-link h-0"></a>
              </div>
          </div>
        </div>
      </div>
    </main>

    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>
