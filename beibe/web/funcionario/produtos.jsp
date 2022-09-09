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
<<<<<<< HEAD
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">
=======
    <link rel="icon" type="image/x-icon" href="../assets/images/phone-solid.svg">
>>>>>>> 84c5aefa4e2247c99482b40552d05f2f2842a133
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
<<<<<<< HEAD
              <a class="nav-link active" href="/ProdutoServlet?action=listarProduto">Produtos</a>
=======
              <a class="nav-link active" href="produtos.jsp">Produtos</a>
>>>>>>> 84c5aefa4e2247c99482b40552d05f2f2842a133
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
<<<<<<< HEAD
      <a href="/ProdutoServlet?action=cadastroProduto" class="btn btn-lg btn-primary">
=======
      <a href="cadastroProduto.jsp" class="btn btn-lg btn-primary">
>>>>>>> 84c5aefa4e2247c99482b40552d05f2f2842a133
        <i class="fa fa-plus"></i>
        Criar Novo Produto
      </a>

      <!-- Tabela com atendimentos em aberto -->
      <div class="mt-5">
<<<<<<< HEAD
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
=======
        <table class="table table-hover">
          <thead class="c-thead">
            <tr class="text-center">
              <th scope="col">#</th>
              <th scope="col">Nome</th>
              <th scope="col">Categoria</th>
              <th scope="col">Peso</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr class="text-center">
              <th scope="row">50001</th>
              <td class="text-left">Sabonete (sabor lavanda)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50002</th>
              <td class="text-left">Sabonete (sabor erva-doce)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50003</th>
              <td class="text-left">Base (sabor cereja)</td>
              <td class="text-left">Maquiagens</td>
              <td class="text-left">80g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50004</th>
              <td class="text-left">Batom Cacatua Raivosa</td>
              <td class="text-left">Batons</td>
              <td class="text-left">15g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50005</th>
              <td class="text-left">Creme Hidratante Ar & Baba</td>
              <td class="text-left">Hidratantes</td>
              <td class="text-left">180g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50006</th>
              <td class="text-left">Sabonete (sabor lavanda)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50007</th>
              <td class="text-left">Sabonete (sabor erva-doce)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50008</th>
              <td class="text-left">Base (sabor cereja)</td>
              <td class="text-left">Maquiagens</td>
              <td class="text-left">80g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50009</th>
              <td class="text-left">Batom Cacatua Raivosa</td>
              <td class="text-left">Batons</td>
              <td class="text-left">15g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50010</th>
              <td class="text-left">Creme Hidratante Ar & Baba</td>
              <td class="text-left">Hidratantes</td>
              <td class="text-left">180g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50011</th>
              <td class="text-left">Sabonete (sabor lavanda)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50012</th>
              <td class="text-left">Sabonete (sabor erva-doce)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50013</th>
              <td class="text-left">Base (sabor cereja)</td>
              <td class="text-left">Maquiagens</td>
              <td class="text-left">80g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50014</th>
              <td class="text-left">Batom Cacatua Raivosa</td>
              <td class="text-left">Batons</td>
              <td class="text-left">15g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50015</th>
              <td class="text-left">Creme Hidratante Ar & Baba</td>
              <td class="text-left">Hidratantes</td>
              <td class="text-left">180g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50016</th>
              <td class="text-left">Sabonete (sabor lavanda)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50017</th>
              <td class="text-left">Sabonete (sabor erva-doce)</td>
              <td class="text-left">Sabonetes</td>
              <td class="text-left">50g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50018</th>
              <td class="text-left">Base (sabor cereja)</td>
              <td class="text-left">Maquiagens</td>
              <td class="text-left">80g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50019</th>
              <td class="text-left">Batom Cacatua Raivosa</td>
              <td class="text-left">Batons</td>
              <td class="text-left">15g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
            <tr class="text-center">
              <th scope="row">50020</th>
              <td class="text-left">Creme Hidratante Ar & Baba</td>
              <td class="text-left">Hidratantes</td>
              <td class="text-left">180g</td>
              <td>
                <a href="menuProdutos.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuProdutos.html" class="btn btn-sm btn-info" title="Editar"><i class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
            </tr>
          </tbody>
>>>>>>> 84c5aefa4e2247c99482b40552d05f2f2842a133
        </table>
      </div>
    </main>

    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>
