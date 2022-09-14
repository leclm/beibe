<%-- 
    Document   : colaboradoresGerente
    Created on : 14 de set de 2022, 12:10:36
    Author     : grupo2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.beibe.beans.LoginBean"%>
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
  <jsp:include page="headerGerente.jsp" />

  <!-- Corpo da página -->
  <main class="container">
    <h2 class="mb-4">
      Cadastro de Funcionários & Gerentes
    </h2>

    <!-- Botão para abertura de novo atendimento -->
    <a href="UsuarioServlet?action=entrarAddColaboradores" class="btn btn-lg btn-primary">
      <i class="fa fa-plus"></i>
      Novo Colaborador
    </a>

    <!-- Tabela com atendimentos em aberto -->
    <div class="mt-5">
      <table class="table table-hover">
        <thead class="c-thead">
          <tr class="text-center">
            <th scope="col">#</th>
            <th scope="col">CPF</th>
            <th scope="col">Nome Completo</th>
            <th scope="col">Nascido em</th>
            <th scope="col">Telefone</th>
            <th scope="col">Gerente</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr class="text-center">
            <th scope="row">111</th>
            <td>123.456.789-10</td>
            <td class="text-left">Claudia Bastchen</td>
            <td>17-jun-1987</td>
            <td>(41) 9 9999-9999</td>
            <td><i class="fas fa-user-check"></i></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
          <tr class="text-center">
            <th scope="row">222</th>
            <td>321.456.789-10</td>
            <td class="text-left">Erica Riera</td>
            <td>21-mai-1995</td>
            <td>(41) 9 9999-8888</td>
            <td></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
          <tr class="text-center">
            <th scope="row">333</th>
            <td>213.456.789-10</td>
            <td class="text-left">Leticia</td>
            <td>01-jan-1998</td>
            <td>(41) 9 9999-7777</td>
            <td><i class="fas fa-user-check"></i></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
          <tr class="text-center">
            <<th scope="row">444</th>
              <td>111.456.789-10</td>
              <td class="text-left">Luiz</td>
              <td>08-mar-1987</td>
              <td>(41) 9 9999-6666</td>
              <td></td>
              <td>
                <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                    class="fas fa-eye"></i></a>
                <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                    class="fas fa-edit"></i></a>
                <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              </td>
          </tr>
          <tr class="text-center">
            <th scope="row">555</th>
            <td>333.456.789-10</td>
            <td class="text-left">Jackson</td>
            <td>30-abr-1995</td>
            <td>(41) 9 9999-5555</td>
            <td></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
          <tr class="text-center">
            <th scope="row">666</th>
            <td>100.456.789-10</td>
            <td class="text-left">Julia Carrara</td>
            <td>14-jul-1999</td>
            <td>(41) 9 9999-4444</td>
            <td></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
          <tr class="text-center">
            <th scope="row">777</th>
            <td>777.456.789-10</td>
            <td class="text-left">Bruno Marquez</td>
            <td>16-dez-1997</td>
            <td>(41) 9 9999-3333</td>
            <td></td>
            <td>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="menuColaboradoresGerente.html" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="#" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <jsp:include page="footer.jsp" />
</body>

</html>