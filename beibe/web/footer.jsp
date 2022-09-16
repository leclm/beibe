<%-- 
    Document   : footer
    Created on : 12 de set de 2022, 18:39:37
    Author     : nicol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Footer contendo js externo e do projeto, além do modal padrão de mensagem -->

<!-- JS externo - jquerry, mask, bootstrap, etc -->

<script
    src="https://code.jquery.com/jquery-3.3.1.min.js"
></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"
></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"
></script>
 
<!-- JS do projeto -->

<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/cep.js"></script>
<script src="${pageContext.request.contextPath}/js/mask.js"></script>

<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
<jsp:useBean id="configuracao" class="com.ufpr.tads.beibe.beans.ConfigBean" scope="application" /> 
<div class="text-secondary c-subtitle mt-5">
  <p class ="text-center">Serviço de Atendimento ao Cliente da <strong>Embuste</strong><sup>&copy;</sup></p>
  <p class ="text-center"> ${configuracao.endereco}
  <p class ="text-center"><i class="fa fa-phone-alt"></i> ${configuracao.telefone}</p>
  <p class ="text-center"><i class="fas fa-at"></i> ${configuracao.emailAdm}</p>
</div>
