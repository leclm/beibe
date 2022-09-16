$('#buscar-produto').click(() => {
  const produto = $('#codigo-produto').val();
  $('#detalhes-produto').show();
});

// Adicionar evento para linhas de tabelas
$('.c-clickable').click(function() {
  window.location = $(this).data('href');
});
$('a[title="Excluir"]').click(function(e) {
  e.preventDefault();
  if (confirm('Tem certeza que quer excluir este item?')) {
    $(this).parent().parent().remove();
  }
});

// Adicionar evento para filtro de tabelas
$('#filtro-atendimentos').change(function() {
  $('tr').show();
  if ($(this).val() === 'abertos') {
    $('td span.badge-secondary').parent().parent().hide();
  }
});