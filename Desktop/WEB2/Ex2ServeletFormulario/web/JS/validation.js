/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validateForm() {
  var id = document.forms["myForma"]["login"].value;
  var senha = document.forms["myForm"]["senha"].value;
  if (id == "") {
    alert("Preencha o usuário");
    return false;
  }
  if (senha == "") {
    alert("Preencha a senha");
    return false;
  }
}