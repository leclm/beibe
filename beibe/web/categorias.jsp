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
      SAC - Categorias
    </title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/fontawesome.min.css" />
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">
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
              <a class="nav-link" href="funcionario.jsp">Início</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="atendimentos.jsp">Atendimentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="categorias.jsp">Categorias</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="produtos.jsp">Produtos</a>
            </li>
          </ul>
        </div>
        <div class="form-inline">
          <a href="index.jsp" class="alert-link text-white my-2 my-sm-0">
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
      <a href="cadastroCategoria.jsp" class="btn btn-lg btn-primary">
        <i class="fa fa-plus"></i>
        Criar Nova Categoria
      </a>

      <!-- Tabela com atendimentos em aberto -->
      <div class="mt-5">
        <table class="table table-hover">
          <thead class="c-thead">
            <tr class="text-center">
              <th scope="col">#</th>
              <th scope="col">Descrição</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-center">
              <th scope="row">2001</th>
              <td>Sabonetes</td>
              <td>
                <a href="menuCategorias.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuCategorias.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">2002</th>
              <td>Maquiagens</td>
              <td>
                <a href="menuCategorias.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuCategorias.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">2003</th>
              <td>Batons</td>
              <td>
                <a href="menuCategorias.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuCategorias.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">2004</th>
              <td>Xampus Femininos</td>
              <td>
                <a href="menuCategorias.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuCategorias.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">2005</th>
              <td>Xampus Masculinos</td>
              <td>
                <a href="menuCategorias.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuCategorias.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
    
  

    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
