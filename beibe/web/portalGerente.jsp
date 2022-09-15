<%-- 
    Document   : portalGerente
    Created on : 14 de set de 2022, 11:40:18
    Author     : nicol
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

  <!-- Cabeçalho da página -->
  <jsp:include page="headerGerente.jsp" />

  <!-- Corpo da página -->
  <main class="container">
    <h2 class="mb-4">
      Bem-vindo(a), <strong>${sessionScope.user.nome}</strong>
    </h2>
    <div>
        <h5 class="text-success">Total de Atendimentos:</h5>
        <h5>
            <small class="text-muted"><c:out value="${requestScope.qntAtendimentosTotal}"/></small>
        </h5>
            
        <h5 class="text-success">Atendimentos em Aberto:</h5>
        <h5>
            <c:set var="porcentagemAtendimentosAbertos" scope="request" value="${requestScope.qntAtendimentosAbertos/requestScope.qntAtendimentosTotal}"/>
            <small class="text-muted"><c:out value="${requestScope.qntAtendimentosAbertos}"/> (<fmt:formatNumber type = "percent" maxIntegerDigits="3" minFractionDigits = "2" value = "${porcentagemAtendimentosAbertos}"/>)</small>
        </h5>
        
        </br><h2 class="mb-4">Categorias de Atendimentos</h2>
        <table class="table table-hover">
            <thead class="c-thead">
                <tr>
                    <th scope="col">Categoria</th>
                    <th scope="col">Total de Atendimentos</th>
                    <th scope="col">Atendimentos em Aberto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categoriasAtendimento}" var="categoria">
                    <tr>
                        <td><c:out value="${categoria.nome}"/></td>
                        <td><c:out value="${categoria.totalAtendimentos}"/></td>
                        <td><c:out value="${categoria.atendimentosAbertos}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
  </main>

   <jsp:include page="footer.jsp" />
</body>

</html>
