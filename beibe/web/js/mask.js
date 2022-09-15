/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//adicionar Máscaras e validação cpf
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

var reDigits = /^\d+$/;

function numInteiro(pStr)
{
	if (reDigits.test(pStr))
	{
		return true;
	}
	else
	if (pStr != null && pStr != "")
	{
		return false;
	}
}

var reDecimalPt = /^[+-]?((\d+|\d{1,3}(\.\d{3})+)(\,\d*)?|\,\d+)$/;
var reDecimalEn = /^[+-]?((\d+|\d{1,3}(\,\d{3})+)(\.\d*)?|\.\d+)$/;
var reDecimal = reDecimalPt;


function validaCPF(cpf)
{
		cpf = cpf.replace('.','');
		cpf = cpf.replace('.','');
		cpf = cpf.replace('-','');

		erro = new String;
		if (cpf.length < 11) erro += "Sao necessarios 11 digitos para verificacao do CPF! \n";
		var nonNumbers = /\D/;
		if (nonNumbers.test(cpf)) erro += "A verificacao de CPF suporta apenas numeros! \n\n";
		if (cpf == "00000000000" || cpf == "11111111111" ||
		cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" ||
                cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" ||
                cpf == "88888888888" || cpf == "99999999999")
                { erro += "Numero de CPF invalido!"
		}
		var a = [];
		var b = new Number;
		var c = 11;
		for (i=0; i<11; i++){
			a[i] = cpf.charAt(i);
			if (i <  9) b += (a[i] *  --c);
		}
		if ((x = b % 11) < 2) { a[9] = 0; } else { a[9] = 11-x;}
		b = 0;
		c = 11;
		for (y=0; y<10; y++) b += (a[y] *  c--);
		if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
		status = a[9] + ""+ a[10];
		if ((cpf.charAt(9) !== a[9]) || (cpf.charAt(10) !== a[10])){
			erro +="Digito verificador com problema!";
		}
		if (erro.length > 0){
			return false;
		}
		return true;
}

