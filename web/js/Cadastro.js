function maskCPF(event) {
    let input = event.target;
    let value = input.value.replace(/\D/g, ''); //remove todos os caracteres que não são numeros do valor do input
    let formattedValue = ''; //armazena o valor final

    for (let i = 0; i < value.length; i++) { //enquanto o valor de i for menor o comprimento do input
        if (i === 3 || i === 6) { //após a posição de número 3 e 6 um ponto será adicionado
            formattedValue += '.';
        } else if (i === 9) {
            formattedValue += '-';
        }
        formattedValue += value[i]; //todo valor numerico passado pelo input sera adicionado nessa nova variável junto com os pontos e o traço
    }

    input.value = formattedValue; //devolve o valor modificado para o input
}

function maskTelefone(event) {
    let input = event.target;
    let value = input.value.replace(/\D/g, '');
    let formattedValue = '(';

    for (let i = 0; i < value.length; i++) {
        if (i === 2) {
            formattedValue += ') ';
        } else if (i === 7) {
            formattedValue += '-';
        }
        formattedValue += value[i];
    }

    input.value = formattedValue;
}

let hoje = new Date();
let maxDate = new Date(hoje.getFullYear() - 18, hoje.getMonth(), hoje.getDate()); //o código pega o ano, mês, e dia mínimos para que o usuário tenha 18 anos a partir da data do próprio dia
let maxDateString = maxDate.toISOString().substr(0, 10);
document.getElementById('#data_nascimento').setAttribute('max', maxDateString);

function float(event) {
    var keyCode = event.keyCode;

    if ((keyCode >= 48 && keyCode <= 57) || keyCode == 46 || keyCode == 8 || keyCode == 9) {
        return true;
    } else {
        event.preventDefault();
        return false;
    }
}


