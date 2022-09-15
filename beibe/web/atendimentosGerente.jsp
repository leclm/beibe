<%-- 
    Document   : index
    Created on : 8 de set de 2022, 13:55:28
    Author     : lelim
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<jsp:useBean id="dataBean" class="java.util.Date"/>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>
      SAC - Atendimentos
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
        Atendimentos
      </h2>

      <!-- Filtro de visualização de atendimentos -->
      <div class="mt-3">
        <div class="form-inline p-2 text-center">
          <div class="mr-3 form-inline">
            <label for="filtro-atendimentos">
              <i class="fas fa-filter"></i>
              <span class="mx-2">Visualizar:</span>
            </label>
            <select id="filtro-atendimentos" class="form-control">
              <option value="todos">Todos</option>
              <option value="abertos">Abertos</option>
            </select>
          </div>
        </div>

        <!-- Tabela de atendimentos -->
        <table class="table table-hover">
          <thead class="c-thead">
            <tr class="text-center">
              <th scope="col">ID</th>
              <th scope="col">Produto</th>
              <th scope="col">Categoria</th>
              <th scope="col">Data de Criação</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${atendimentos}" var="a" >
                <c:choose>
                    <c:when test = "${a.situacaoAtendimento.nome.equals('Aberta')}">
                        <c:choose>
                            <c:when test="${(((dataBean.getTime() - a.dataHr.getTime()) / (1000 * 60 * 60 * 24)) % 365) ge 7}">
                                <tr class="table-danger text-center">
                            </c:when>
                            <c:otherwise>
                                <tr class="table-warning text-center">
                            </c:otherwise>
                        </c:choose>
                          <td><c:out value="${a.id}"/></td>
                          <td><c:out value="${a.produto.nome}"/></td>
                          <td><c:out value="${a.categoriaAtendimento.nome}"/></td>
                          <td><fmt:formatDate value="${a.dataHr}" pattern="dd/MM/yyyy HH:mm"/></td>
                          <td><span class="badge badge-sm badge-info c-status"><c:out value="${a.situacaoAtendimento.nome}"/></span></td>
                        </tr>
                    </c:when>

                    <c:when test = "${a.situacaoAtendimento.nome.equals('Finalizada')}">
                        <tr class="table-dark text-center">
                          <td><c:out value="${a.id}"/></td>
                          <td><c:out value="${a.produto.nome}"/></td>
                          <td><c:out value="${a.categoriaAtendimento.nome}"/></td>
                          <td><fmt:formatDate value="${a.dataHr}" pattern="dd/MM/yyyy HH:mm"/></td>
                          <td><span class="badge badge-sm badge-secondary c-status"><c:out value="${a.situacaoAtendimento.nome}"/></span></td>
                        </tr>
                    </c:when>

                    <c:otherwise>
                        <tr class="text-center">
                          <td><c:out value="Ocorreu um erro..."/></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </main>

    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/scripts.js"></script>
    <jsp:include page="footer.jsp" />
  </body>
</html>