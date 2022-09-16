<%-- 
    Document   : cadastroCliente
    Created on : 7 de ago de 2022, 21:19:28
    Author     : grupo2
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BEIBE SAC - Cadastro</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <link rel="stylesheet" href="./css/styles.css" />
    <link rel="icon" type="image/x-icon" href="assets/images/phone-solid.svg">

  </head>
  <body>

    <div class=" d-flex justify-content-center">
      <!-- Formulário de cadastro -->
      <div class="col-6 p-3 d-flex align-items-stretch">
        <form action="UsuarioServlet?action=autocadastro" method="POST" class="submit-jsp card text-center bg-info">
          <h2 class="card-header text-light font-weight-bolder">Cadastro</h2>
          <div class="card-body">
            <p class="card-text text-light">Primeiro acesso? Crie sua conta:</p>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fa fa-address-card"></i>
                </span>
              </div>
              <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF"/>
            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
              <input type="text" class="form-control" maxlength="99" name="nome" placeholder="Nome completo" />
            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-at"></i>
                </span>
              </div>
              <input type="email" class="form-control" name="email" maxlength="99" placeholder="email@email.com" />
            </div>
            <div class="input-group mb-3">

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-mobile-alt"></i>
                  </span>
                </div>  
                <input type="tel" name="telefone" class="form-control" id="telefone" placeholder="(41) 99999-9999" />
              </div>
            </div>

            <div class="form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map-marker-alt"></i>
                </span>
                <input type="text" class="form-control" name="cep" placeholder="CEP" />
              </div>
            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fa fa-map-marked-alt"></i>
                </span>
              </div>
              <input type="text" class="form-control" name="rua" maxlength="99" placeholder="Logradouro" />
            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-map-marked-alt"></i>
                </span>
              </div>
              <input type="text" class="form-control" name="numero" maxlength="4" placeholder="Número" />
              <input type="text" class="form-control" name="complemento" maxlength="49" placeholder="Complemento" />
              <input type="text" class="form-control" name="bairro" maxlength="49" placeholder="Bairro" />
            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-globe-americas"></i>
                </span>
              </div>

              <input
                  required
                  type="text"
                  name="cidade"
                  class="form-control"
                  placeholder="Cidade"
                  id="clienteCidade"
                  maxlength="49"
                  />

              <input
                  required
                  type="text"
                  name="estado"
                  class="form-control"
                  placeholder="Estado"
                  maxlength="2"
                  id="clienteEstado"
                  />  

            </div>
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-unlock-alt"></i>
                </span>
              </div>
              <input type="password" class="form-control" name="senha" maxlength="512" placeholder="Senha" />
            </div>
          </div>
          <div class="card-footer text-center">
            <button type="submit" class="btn btn-lg btn-light w-75">
              Cadastrar
            </button>
          </div>
        </form>
      </div>
    </div>
    <jsp:include page="footer.jsp" />
  </body>
  <script src="./js/mask.js"></script>
  <script src="./js/cep.js"></script>


</html>
