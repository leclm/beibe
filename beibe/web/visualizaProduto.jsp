<%-- 
    Document   : index
    Created on : 10 de set de 2022, 18:55:28
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
      SAC - Atualiza Produto
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="../assets/images/phone-solid.svg">
  </head>
  
  <body>
    <!-- Cabeçalho da página -->
    <jsp:include page="headerFuncionario.jsp" />
    
    <!-- Corpo da página -->
    <main class="container">
      <h2 class="mb-4">
        Visualizar Produto
      </h2>

 

      <!-- Formulário para alteração de produto -->
      <form action="ProdutoServlet?action=adicionarProduto" method="POST">
        <div class="row">
          <div class="col-12 jsutify-content-between">
            <h3 class="mb-3 h4">Dados Cadastrais</h3>
          </div>
          <div class="col-12 col-md-6">
            <div class="form-group">
              <p>Nome do produto:</p>
              <p id="nome" class="form-control" name="nome">
                ${produto.nome}
              </p>
            </div>
            <div class="form-group">
              <p>Descrição:</p>
              <p id="descricao" name="descricao" class="form-control">
                ${produto.descricao}
              </p>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="form-group">
              <p>Categoria:</p>
              <p id="idcategoria" name="idcategoria" class="form-control">
                ${param.categoria}
              </p>
            </div>
            <div class="form-group">
              <p>Peso:</p>
              <p id="peso" name="peso" class="form-control">
                ${produto.peso}
              </p>
            </div>
          </div>
        </div>
      </form>
      <a class="w-25" href="ProdutoServlet?action=listarProduto">
        <button type="submit" class="btn btn-primary w-25">
            Voltar
        </button>
      </a>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
    <jsp:include page="footer.jsp" />
  </body>
</html>