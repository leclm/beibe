<%-- 
    Document   : dadosCliente
    Created on : 25 de ago de 2022, 20:25:52
    Author     : grupo2
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  <header class="container-fluid bg-info mb-4">
    <nav class="navbar navbar-expand-lg navbar-light" role="navigation">
      <a class="navbar-brand" href="index.jsp">
        <img src="./assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
        <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
      </a>
      <div class="container">
        <ul class="navbar-nav text-white">
          <li class="nav-item">
            <a class="nav-link" href="portalCliente.jsp">Meus Atendimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="dadosClientes.jsp">Meus Dados</a>
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
    <h2 class="mb-4">
      Meus Dados
    </h2>

    <!-- Formulário dos dados do usuário -->
    <form action="#" method="POST" class="mt-5">
      <div class="row">
        <div class="col-12 jsutify-content-between">
          <button type="submit" class="btn btn-primary float-right w-25">
            <i class="far fa-save"></i>
            Salvar
          </button>
          <h3 class="mb-3 h4">Dados Pessoais</h3>
        </div>
        <div class="col-12 col-md-6">
          <div class="form-group">
            <label for="cliente-nome">Nome completo:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
              <input type="text" id="cliente-nome" class="form-control" value="Claudia bastchen" />
            </div>
          </div>
          <div class="form-group">
            <label for="cliente-cpf">CPF:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fab fa-slack-hash"></i>
                </span>
              </div>
              <input type="text" id="cliente-cpf" class="form-control" value="000.000.000-00" readonly />
            </div>
          </div>
          <div class="form-group">
            <label for="cliente-email">E-mail:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-at"></i>
                </span>
              </div>
              <input type="email" id="cliente-email" class="form-control" value="claudia@email.com" readonly />
            </div>
          </div>
          <div class="form-group">
            <label for="cliente-telefone">Telefone para contato:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-mobile-alt"></i>
                </span>
              </div>
              <input type="text" id="cliente-telefone" class="form-control" value="(41) 99999-9999" />
            </div>
          </div>
        </div>
        <div class="col-12 col-md-6">
          <div class="form-group">
            <label for="cliente-cep">CEP:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map-marker-alt"></i>
                </span>
              </div>
              <input type="text" id="cliente-cep" class="form-control" name="cep" value="88888-000" />
              <div class="input-group-append">
                <button class="btn btn-secondary" type="button" id="buscar-cep">
                  Buscar CEP
                </button>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="cliente-rua">Rua / Avenida:</label>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map"></i>
                </span>
              </div>
              <input type="text" id="cliente-rua" class="form-control" name="rua" value="Rua Tads" readonly />
            </div>
          </div>
          <div class="row">
            <div class="col-6">
              <div class="form-group">
                <label for="cliente-numero">Número:</label>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fas fa-map-marked-alt"></i>
                    </span>
                  </div>
                  <input type="number" id="cliente-numero" class="form-control" name="numero" value="1000">
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="form-group">
                <label for="cliente-complemento">Complemento:</label>
                <input type="text" id="cliente-complemento" class="form-control" name="complemento" value="Ap 100" />
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="cliente-complemento">Bairro:</label>
            <input readonly type="text" id="cliente-bairro" class="form-control" name="bairro" value="Centro" />  
          </div>  
          <div class="form-group">
            <label for="cliente-cidade">Cidade:</label>
            <input type="text" id="cliente-cidade" class="form-control" name="cidade" value="Curitiba" readonly />   
          </div>
          <div class="row">
            <div class="col-6">
              <div class="form-group">
                <label for="cliente-estado">Estado:</label>
                <input type="text" id="cliente-estado" class="form-control" name="estado" value="PR" readonly />
              </div>
            </div>
            <div class="col-6">
              <div class="form-group">
                <label for="cliente-pais">País:</label>
                <input type="text" id="cliente-pais" class="form-control" value="Brasil" readonly />
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>

    <!-- Formulário de alteração de senha -->
    <form action="#" method="POST" class="mt-5">
      <div class="row">
        <div class="col-12 jsutify-content-between">
          <button type="submit" class="btn btn-primary float-right w-25">
            <i class="far fa-save"></i>
            Alterar
          </button>
          <h3 class="mb-3 h4">Alterar Senha</h3>
        </div>
        <div class="col-12 col-md-6">
          <div class="form-group">
            <label for="cliente-senha-atual">Senha atual:</label>
            <input type="password" id="cliente-senha-atual" class="form-control" name="senha_atual" />
          </div>
          <div class="form-group">
            <label for="cliente-senha-nova1">Nova senha:</label>
            <input type="password" id="cliente-senha-nova1" class="form-control" name="senha_nova1" />
          </div>
          <div class="form-group">
            <label for="cliente-senha-nova2">Repetir nova senha:</label>
            <input type="password" id="cliente-senha-nova2" class="form-control" name="senha_nova2" />
          </div>
        </div>
      </div>
    </form>
  </main>

  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/scripts.js"></script>
</body>

</html>