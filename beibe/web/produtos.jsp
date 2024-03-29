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
      SAC - Cadastro Produtos
    </title>
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">
  </head>
  <script type="text/javascript">
    function removerProduto(id) {
        excluir = confirm('Tem certeza que deseja excluir a categoria?');
        if (excluir) {
            document.location.href= "ProdutoServlet?action=removerProduto&id=" + id;
        }
    }
  </script>
  <body>
    <!-- Cabeçalho da página -->
    <jsp:include page="headerFuncionario.jsp" />
    
    <!-- Corpo da página -->
    <main class="container">
      <h2 class="mb-4">
        Produtos
      </h2>

      <!-- Botão para abertura de novo atendimento -->
      <a href="ProdutoServlet?action=cadastroProduto" class="btn btn-lg btn-primary">
        <i class="fa fa-plus"></i>
        Criar Novo Produto
      </a>

      <!-- Tabela com atendimentos em aberto -->
      <div class="mt-5">
        <table id="login-table" class="table table-hover mb-0">
            <div class="table-group">
                <div class="row">
                    <div class="col-md-6">
                        <thead for="categoria" class="c-thead">
                            <tr class="text-center">
                                <th scope="col" class="table-dark align-middle">Produto</th>
                                <th scope="col" class="table-dark align-middle">Categoria</th>
                                <th scope="col" class="table-dark align-middle">Peso</th>
                                <th scope="col" class="table-dark align-middle"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listProduto}" var="produto">
                                <tr class="text-center">
                                    <td>${produto.nome}</td>
                                    <td>${produto.categoriaProduto.nome}</td>
                                    <td>${produto.peso}</td>
                                    <td>
                                        <a href="ProdutoServlet?action=visualizarProduto&id=${produto.id}&categoria=${produto.categoriaProduto.nome}" class="btn btn-sm btn-success" title="Visualizar">
                                            <i class="fas fa-eye"></i>
                                        </a>
                                        <a href="ProdutoServlet?action=alteraProduto&id=${produto.id}&categoria=${produto.categoriaProduto.nome}" class="btn btn-sm btn-info" title="Editar">
                                            <i class="fas fa-edit"></i>
                                        </a>
                                        <button type="button" class="btn btn-sm btn-danger" onclick="removerProduto(${produto.id})" title="Excluir">
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
    <jsp:include page="footer.jsp" />
  </body>
</html>
