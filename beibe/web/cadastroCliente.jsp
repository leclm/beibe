<%-- 
    Document   : cadastroCliente
    Created on : 7 de ago de 2022, 21:19:28
    Author     : grupo2
--%>

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
          <form action="UsuarioServlet?action=autocadastro" method="POST" class="card text-center bg-info">
            <h2 class="card-header text-light font-weight-bolder">Cadastro</h2>
            <div class="card-body">
                <p class="card-text text-light">Primeiro acesso? Crie sua conta:</p>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fa fa-address-card"></i>
                  </span>
                </div>
                <input type="number" class="form-control" name="cpf" placeholder="CPF"/>
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-user"></i>
                  </span>
                </div>
                <input type="text" class="form-control" name="nome" placeholder="Nome completo" />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-at"></i>
                  </span>
                </div>
                <input type="email" class="form-control" name="email" placeholder="email@email.com" />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-map-marker-alt"></i>
                  </span>
                </div>
                <input type="number" class="form-control" name="cep" placeholder="CEP" />
                 <div class="input-group-append">
                  <button class="btn btn-outline-secondary text-light" type="button" id="buscar-cep">
                    Buscar CEP
                  </button>
                </div>
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fa fa-map-marked-alt"></i>
                  </span>
                </div>
                <input type="text" class="form-control" name="rua" placeholder="Rua: xxxxxxxxxx" />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-map-marked-alt"></i>
                  </span>
                </div>
                <input type="number" class="form-control" name="numero" placeholder="Número" />
                <input type="text" class="form-control" name="complemento" placeholder="Complemento" />
                <input type="text" class="form-control" name="bairro" placeholder="Bairro" />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-globe-americas"></i>
                  </span>
                </div>
                <input type="text" class="form-control" name="cidade" placeholder="Cidade" />
                <input type="text" class="form-control" name="estado" placeholder="Estado"  />
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <span class="input-group-text">
                    <i class="fas fa-unlock-alt"></i>
                  </span>
                </div>
                <input type="password" class="form-control" name="senha" placeholder="Senha" />
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
    <div class="text-secondary c-subtitle">
      <p class ="text-center">Serviço de Atendimento ao Cliente da <strong>Embuste</strong><sup>&copy;</sup></p>
      <p class ="text-center"> Rua do Embuste, 1313. Curitiba, PR, 13131-313
      <p class ="text-center"><i class="fa fa-phone-alt"></i>(41) 9 1313-1313</p>
    </div>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
