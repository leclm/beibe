<%-- 
    Document   : headerCliente
    Created on : 13 de set de 2022, 17:11:03
    Author     : grupo2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="configuracao" class="com.ufpr.tads.beibe.beans.ConfigBean" scope="application" /> 
  <header class="container-fluid bg-info mb-4">
    <nav class="navbar navbar-expand-lg navbar-light" role="navigation">
      <a class="navbar-brand" href="index.html">
        <img src="./assets/sacW.png" width="30" height="30" class="d-inline-block align-top" alt="Logo do sistema" />
        <span class="text-white-50 h4 c-title">SAC - Sistema de Atendimento ao Cliente</span>
      </a>
      <div class="container">
        <ul class="navbar-nav text-white">
          <li class="nav-item">
            <a class="nav-link active" href="portalGerente.jsp">Início</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="atendimentos.html">Atendimentos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="UsuarioServlet?action=colaboradoresGerente">Cadastro de Colaboradores</a>
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