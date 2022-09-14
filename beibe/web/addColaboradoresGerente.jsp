<%-- 
    Document   : addColaboradoresGerente
    Created on : 14 de set de 2022, 12:19:07
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
      Funcionário/Gerente
    </h2>

    <!-- Formulário para add os dados do colaborador -->
   <form action="UsuarioServlet?action=adicionaColabolador" method="POST" class="mt-5">
      
      <div class="row">
        <div class="col-12 jsutify-content-between">
          <button type="submit" class="btn btn-primary float-right w-25">
            <i class="far fa-save"></i>
            Salvar
          </button>
         </div>
        </div>
           <div class="form-group">
            <h3 class="mb-3 h4">Escolha a Função:</h3>
            <div class="col-4 col-md-3">
           <div class="input-group mb-lg-3">
              <input type="radio" id="funcionario" class="form-control" name="tipo" value="funcionario"/>
              <label for="funcionario">Funcionário</label><br>
              <input type="radio" id="gerente" class="form-control" name="tipo" value="gerente"/>
              <label for="gerente">Gerente</label><br>
            </div>
             </div>
           </div>
           
          <h3 class="mb-3 h4">Dados Pessoais</h3>
       
        <div class="col-12 col-md-6">
          <div class="form-group">
            <label for="clienteNome">Nome completo:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
                <input type="text" id="clienteNome" class="form-control" name="nome" value="${cliente.nome}" />
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
                <input type="text" id="clienteCpf" name="cpf" class="form-control" value="${cliente.cpf}" readonly />
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
                <input type="email" id="clienteEmail" name="email" class="form-control" value="${cliente.email}" readonly />
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
                <input type="text" id="clienteTelefone" name="telefone" class="form-control" value="${cliente.telefone}" />
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
                <input type="text" id="clienteCep"  class="form-control" name="cep" value="${cliente.cep}" />
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
                <input type="text" id="clienteRua" class="form-control" name="rua" value="${cliente.rua}"/>
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
                    <input type="text" id="clienteNumero" class="form-control" name="numero" value="${cliente.nr}"/>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="form-group">
                <label for="clienteComplemento">Complemento:</label>
                <input type="text" id="clienteComplemento" class="form-control" name="complemento" value="${cliente.complemento}" />
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="clienteBairro">Bairro:</label>
            <input type="text" id="clienteBairro" class="form-control" name="bairro" value="${cliente.bairro}" />  
          </div>  
          <div class="form-group">
            <label for="clienteCidade">Cidade:</label>
            <select  id="clienteCidade" class="form-control" name="cidade">
                    <option value="">Selecione</option>
                        <c:forEach items="${cidades}" var="city">
                            <option value="${city.nome}"<c:if test="${cliente.cidade == city.nome}">selected</c:if>>${city.nome}</option>
                        </c:forEach>
            </select>
          </div>
          <div class="row">
            <div class="col-6">
              <div class="form-group">
                <label for="clienteEstado">Estado:</label>
                <select  id="clienteEstado" class="form-control" name="estado">
                    <option value="">Selecione</option>
                        <c:forEach items="${estados}" var="e">
                            <option value="${e.sigla}"<c:if test="${cliente.uf == e.sigla}">selected</c:if>>${e.sigla}</option>
                        </c:forEach>
                </select>
              </div>
            </div>
          </div>           

    <!-- Formulário de alteração de senha -->
          <h3 class="mb-3 h4">Adicionar Senha</h3>
          <div class="form-group">
            <label for="clienteSenha">Senha:</label>
            <input type="password" id="clienteSenha" class="form-control" name="senha" value="${cliente.senha}"/>
          </div>
      </div>
    </form>
  </main>

<jsp:include page="footer.jsp" />
</body>

</html>