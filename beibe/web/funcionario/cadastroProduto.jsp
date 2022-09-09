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
        Novo Produto
      </h2>

      <!-- Formulário para criação de produto -->
<<<<<<< HEAD
      <form action="${pageContext.request.contextPath}/ProdutoServlet?action=adicionarProduto" method="POST">
=======
      <form action="produtos.jsp" method="POST">
>>>>>>> 84c5aefa4e2247c99482b40552d05f2f2842a133
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
              <label for="produto-nome">Nome do produto:</label>
              <input type="text" id="produto-nome" class="form-control" name="nome"
                placeholder="Digite um nome entre 5 e 32 caracteres" minlengh="5" maxlengh="32" />
            </div>
            <div class="form-group">
              <label for="produto-desc">Descrição:</label>
              <textarea id="produto-desc" class="form-control" name="desc" rows="4"
                placeholder="Escreva informações que qualifiquem o produto (ex.: marca, cor, modelo...)"></textarea>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="form-group">
              <label for="produto-categoria">Categoria:</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-puzzle-piece"></i>
                  </span>
                </div>
                <select id="produto-categoria" class="form-control" name="categoria">
                  <option>Selecione...</option>
                  <option value="2003">Batons</option>
                  <option value="2002">Maquiagens</option>
                  <option value="2001">Sabonetes</option>
                  <option value="2004">Xampus Femininos</option>
                  <option value="2005">Xampus Masculinos</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="col-12 col-md-6">
                <div class="form-group">
                  <label for="produto-utc">Código UTC:</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-barcode"></i>
                      </span>
                    </div>
                    <input type="number" id="produto-utc" class="form-control" name="utc"
                      placeholder="Exemplo: 789000000" />
                  </div>
                </div>
              </div>
              <div class="col-12 col-md-6">
                <div class="form-group">
                  <label for="produto-ean">Código EAN:</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-barcode"></i>
                      </span>
                    </div>
                    <input type="number" id="produto-ean" class="form-control" name="ean"
                      placeholder="Exemplo: 789000000" />
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label for="produto-peso">Peso bruto:</label>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-weight"></i>
                  </span>
                </div>
                <input type="number" id="produto-peso" class="form-control" name="peso" placeholder="Peso em gramas" />
              </div>
            </div>
          </div>
        </div>
      </form>
    </main>

    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>
