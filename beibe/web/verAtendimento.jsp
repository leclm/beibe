<%-- 
    Document   : verAtendimento
    Created on : 10 de set de 2022, 09:30:56
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
    <c:if test="${ sessionScope.user.tipo != 'cliente' }" >
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
    SAC - Sistema de Atendimento ao Cliente :: Trabalho Web 2
  </title>
  <link rel="stylesheet" href="./css/bootstrap.min.css" />
  <link rel="stylesheet" href="./css/fontawesome.min.css" />
  <link rel="stylesheet" href="./css/styles.css" />
  <link rel="icon" type="image/x-icon" href="./assets/images/phone-solid.svg">
</head>
<body>
    <script type="text/javascript">
    function removerAtendimento(id) {
        excluir = confirm('Tem certeza que deseja excluir o atendimento?');
        if (excluir) {
            document.location.href= ("AtendimentoServlet?action=removeAtendimento&ida="+ id);
        }
    }
     </script>
  <!-- Cabeçalho da página -->
<header class="container-fluid bg-info mb-4">
    <nav class="navbar navbar-expand-lg navbar-light" role="navigation">
      <a class="navbar-brand" href="index.jsp">
        <img src="./assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
        <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
      </a>
      <div class="container">
                
        <ul class="navbar-nav text-white">
          <li class="nav-item">
            <a class="nav-link active" href="AtendimentoServlet?action=mostrarPortalCliente">Meus Atendimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="UsuarioServlet?action=mostrarCliente">Meus Dados</a>
          </li>
        </ul>
      </div>
      <div class="form-inline">
        <a href="LogoutServlet" class="alert-link text-white my-2 my-sm-0">
          <i class="fas fa-power-off"></i><br>
          Sair
        </a>
      </div>
    </nav>
  </header>

  <!-- Corpo da página -->
  <main class="container">
       <c:if test="${requestScope.info != null || param.info != null}" >
                      <div class="alert alert-success alert-dismissible fade show">
                          <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                          <span>${requestScope.info == null ? param.info : requestScope.info}</span>
                      </div>
        </c:if>
    <h2 class="mb-4">
        <c:forEach items="${requestScope.atd}" var="a" >
            Atendimento <c:out value="${a.id}"/>
        </c:forEach>    
     
      
    </h2>

    <!-- Dados do atendimento -->
 
      <c:forEach items="${requestScope.atd}" var="a" >    
        
        <c:choose>
            <c:when test="${a.situacaoAtendimento.nome eq 'Finalizada'}">
                <a><button type="button" class="btn btn-danger float-right w-25" onclick="alert('Não é possível remover atendimento finalizado')" >Remover</button></a>
            </c:when>
            <c:otherwise>
                <button onclick= "removerAtendimento(${a.id})" class="btn btn-danger float-right w-25">
                    <i class="far fa-delete"></i>
                Remover
                </button>
            </c:otherwise>
        </c:choose> 
          
      
      <br> 
      <div class="form-group">
      <div class="row">
        <label for="atendimento-cliente" class="col-2 col-form-label">Cliente:</label>
        <div class="col-10">
          <input type="text" id="atendimento-cliente" class="form-control-plaintext" readonly value="${requestScope.nomeu}" />
        </div>
      </div>
     
      <div class="row">
        <label for="atendimento-produto" class="col-2 col-form-label">Produto:</label>
        <div class="col-10">
          <input type="text" id="atendimento-produto" class="form-control-plaintext" readonly
            value="${a.produto.nome}" />
        </div>
      </div>
      <div class="row">
        <label for="atendimento-tipo" class="col-2 col-form-label">Tipo do atendimento:</label>
        <div class="col-10">
          <input type="text" id="atendimento-produto" class="form-control-plaintext" readonly
            value="${a.categoriaAtendimento.nome}" />
        </div>
      </div>
      <div class="row">
        <label for="atendimento-status" class="col-2 col-form-label">Status:</label>
        <div class="col-10">
          <input type="text" id="atendimento-produto" class="form-control-plaintext" readonly
            value="${a.situacaoAtendimento.nome}"/>
      </div>
      </div>
      <br> 
      <div class="form-group">
        <label for="atendimento-msg">Histórico de mensagens:</label>
        <div class="row">
          <div class="col-10 col-md-8">
            <div class="rounded bg-secondary c-mensagem">
              <c:out value="${a.descricao}"/>
              
            </div>
          </div>
          <div class="col-10 col-md-8 offset-2 offset-md-4">
            <div class="rounded bg-primary c-mensagem">
             <c:out value="${a.solucao}"/>
            </div>
          </div>          
        </div>
      </div>
      </c:forEach>   
  </main>

  <jsp:include page="footer.jsp" />
</body>

</html>