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
<c:if test="${ sessionScope.user != null }" >
    <c:if test="${ sessionScope.user.tipo != 'gerente' }" >
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
    SAC - Sistema de Atendimento ao Cliente :: Trabalho Web 2 - Protótipo
  </title>
  <link rel="stylesheet" href="./css/bootstrap.min.css" />
  <link rel="stylesheet" href="./css/fontawesome.min.css" />
  <link rel="stylesheet" href="./css/styles.css" />
  <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
</head>

<body>
       <script type="text/javascript" >
                        function excluirCliente(id)
                        {
                        var x;
                        var r=confirm("Tem certeza que deseja remover o colaborador ${id}?");
                        if (r==true)
                        {
                            href = "UsuarioServlet?action=removeColaborador&id=${id}";
                            x= "Colaborador removido!";
                          }
                        
                        }
        </script>

  <!-- Cabeçalho da página -->
  <jsp:include page="headerGerente.jsp" />

  <!-- Corpo da página -->
  <main class="container">
       <c:if test="${requestScope.info != null || param.info != null}" >
                      <div class="alert alert-success alert-dismissible fade show">
                          <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                          <span>${requestScope.info == null ? param.info : requestScope.info}</span>
                      </div>
        </c:if>
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
            <th scope="col">ID Colaborador</th>
            <th scope="col">CPF</th>
            <th scope="col">Nome Completo</th>
            <th scope="col">Email</th>
            <th scope="col">Telefone</th>
            <th scope="col">Gerente</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${requestScope.colaboradores}" var="c" >
          <tr class="text-center">
            <th scope="row"><c:out value="${c.id}"/></th>
            <td><c:out value="${c.cpf}"/></td>
            <td class="text-left"><c:out value="${c.nome}"/></td>
            <td><c:out value="${c.email}"/></td>
            <td><c:out value="${c.telefone}"/></td>
            <c:if test="${c.tipo == 'gerente'}" >
            <td><i class="fas fa-user-check"></i></td>
            </c:if> 
            <c:if test="${c.tipo == 'funcionario'}">
            <td></td>
            </c:if> 
            <td>
              <a href="UsuarioServlet?action=verColaborador&id=<c:out value="${c.id}"/>" class="btn btn-sm btn-success" title="Visualizar"><i
                  class="fas fa-eye"></i></a>
              <a href="UsuarioServlet?action=entrarAlteraColaboradores&id=<c:out value="${c.id}"/>" class="btn btn-sm btn-info" title="Editar"><i
                  class="fas fa-edit"></i></a>
              <a href="javascript:void(0)" onclick="new excluirCliente(${c.id})" class="btn btn-sm btn-danger" title="Excluir"><i class="fas fa-trash-alt"></i></a>
              
              
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <jsp:include page="footer.jsp" />
</body>

</html>