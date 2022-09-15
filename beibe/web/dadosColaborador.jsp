<%-- 
    Document   : dadosColaborador
    Created on : 14 de set de 2022, 17:10:13
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
     <c:if test="${requestScope.info != null || param.info != null}" >
                      <div class="alert alert-success alert-dismissible fade show">
                          <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                          <span>${requestScope.info == null ? param.info : requestScope.info}</span>
                      </div>
        </c:if>
    <h2 class="mb-4">
      Funcionário/Gerente
    </h2>
      
          
      <div class="row">
        <div class="col-12 jsutify-content-between">
          <h3 class="mb-3 h4">Dados Pessoais</h3>
        </div>
        <div class="col-12 col-md-6">
          <div class="form-group">
            <label for="clienteNome">Função do Colaborador:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteNome" class="form-control" name="nome" value="${colaborador.tipo}" />
            </div>
          <div class="form-group">
            <label for="clienteNome">Nome completo:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteNome" class="form-control" name="nome" value="${colaborador.nome}" />
            </div>
          </div>
          <div class="form-group">
            <label for="clienteCpf">CPF:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fab fa-slack-hash"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteCpf" name="cpf" class="form-control" value="${colaborador.cpf}"/>
            </div>
          </div>
          <div class="form-group">
            <label for="clienteEmail">E-mail:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-at"></i>
                </span>
              </div>
                <input  type="email" id="clienteEmail" name="email" class="form-control" value="${colaborador.email}" readonly />
            </div>
          </div>
          <div class="form-group">
            <label for="clienteTelefone">Telefone:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-at"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteTelefone" name="telefone" class="form-control" value="${colaborador.telefone}" />
            </div>
          </div>
          <div class="form-group">
            <label for="clienteCep">CEP:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map-marker-alt"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteCep"  class="form-control" name="cep" value="${colaborador.cep}" />
            </div>
          </div>
          <div class="form-group">
            <label for="clienteRua">Rua / Avenida:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map"></i>
                </span>
              </div>
                <input readonly type="text" id="clienteRua" class="form-control" name="rua" value="${colaborador.rua}"/>
            </div>
          </div>
          <div class="row">
            <div class="col-6">
              <div class="form-group">
                <label for="clienteNumero">Número:</label>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fas fa-map-marked-alt"></i>
                    </span>
                  </div>
                    <input readonly type="text" id="clienteNumero" class="form-control" name="numero" value="${colaborador.nr}"/>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="form-group">
                <label for="clienteComplemento">Complemento:</label>
                <input readonly type="text" id="clienteComplemento" class="form-control" name="complemento" value="${colaborador.complemento}" />
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="clienteBairro">Bairro:</label>
            <input readonly type="text" id="clienteBairro" class="form-control" name="bairro" value="${colaborador.bairro}" />  
          </div>  
          <div class="form-group">
            <label for="clienteCidade">Cidade:</label>
             <input readonly type="text" id="clienteCidade" class="form-control" name="cidade" value="${colaborador.cidade}" />  
          </div>
          <div class="row">
            <div class="col-6">
              <div class="form-group">
                <label for="clienteEstado">Estado:</label>
                <input readonly type="text" id="clienteEstado" class="form-control" name="estado" value="${colaborador.uf}"/>  
          </div>
            </div>
          </div>           
      </div>
    </div>

  </main>

<jsp:include page="footer.jsp" />
</body>

</html>