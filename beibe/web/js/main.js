$(document).ready(function() {

//Modal delete

$('#confirm-delete').on('show.bs.modal', function(e) {
  var deleteid = $(e.relatedTarget).data('delete');
  $('#delBtn').attr('onClick', "location.href='FuncionarioServlet?action=excluirCategoria&id="+deleteid+"'");
});

$('#confirm-deleteAtendimento').on('show.bs.modal', function(e) {
  var deleteid = $(e.relatedTarget).data('delete');
  $('#delBtn').attr('onClick', "location.href='ClienteServlet?action=excluirAtendimento&id="+deleteid+"'");
});

$('#confirm-deleteProduto').on('show.bs.modal', function(e) {
  var deleteid = $(e.relatedTarget).data('delete');
  $('#delBtn').attr('onClick', "location.href='FuncionarioServlet?action=excluirProduto&idProduto="+deleteid+"'");
});

//Modal configs

const btn = document.getElementById('closeX');
const modal = document.getElementById('MyModal');

btn.addEventListener('click', () => {
  modal.style.display = 'none';
});

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

});