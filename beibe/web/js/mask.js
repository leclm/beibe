 $(document).ready(function($) {
    $("input[name=Cep]").mask('00000-000');
    $("input[name=Telefone]").mask('(00) 00000-0000');
    $("input[name=Cpf]").mask('000.000.000-00');
    $("input[name=cep]").mask('00000-000');
    $("input[name=telefone]").mask('(00) 00000-0000');
    $("input[name=cpf]").mask('000.000.000-00');
    
    $(".submit-jsp").submit(function() {
        $("input[name=Cep]").unmask();
        $("input[name=Telefone]").unmask();
        $("input[name=Cpf]").unmask();
        $("input[name=cep]").unmask();
        $("input[name=telefone]").unmask();
        $("input[name=cpf]").unmask();
    });

});