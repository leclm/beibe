$(document).ready(function () {
    $("input[name=cep]").blur(function () {
        var cep = $(this).val().replace(/[^0-9]/, '');
        if (cep) {
            var url = 'https://viacep.com.br/ws/' + cep + '/json/';
            $.getJSON(url, function (data) {
                if (data.uf) {
                    $("input[name=rua]").val(data.logradouro);
                    $("input[name=bairro]").val(data.bairro);
                    $("input[name=cidade]").val(data.localidade);
                    $("input[name=estado]").val(data.uf);
                    $('input[name="numero"]').focus();
                }
            });
        }
    });
    $("input[name=Cep]").blur(function () {
        var cep = $(this).val().replace(/[^0-9]/, '');
        if (cep) {
            var url = 'https://viacep.com.br/ws/' + cep + '/json/';
            $.getJSON(url, function (data) {
                if (data.uf) {
                    $("input[name=Rua]").val(data.logradouro);
                    $("input[name=Bairro]").val(data.bairro);
                    $("input[name=Cidade]").val(data.localidade);
                    $("input[name=Estado]").val(data.uf);
                }
            });
        }
    });
});