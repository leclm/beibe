<%-- 
    Document   : footer
    Created on : 12 de set de 2022, 18:39:37
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="configuracao" class="com.ufpr.tads.beibe.beans.ConfigBean" scope="application" /> 
    <div class="text-secondary c-subtitle mt-5">
      <p class ="text-center">Serviço de Atendimento ao Cliente da <strong>Embuste</strong><sup>&copy;</sup></p>
      <p class ="text-center"> ${configuracao.endereco}
      <p class ="text-center"><i class="fa fa-phone-alt"></i> ${configuracao.telefone}</p>
      <p class ="text-center"><i class="fas fa-at"></i> ${configuracao.emailAdm}</p>
    </div>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>  

