/*Fiz com a ajuda do Lucas Justino*/
function maskCPF(event) {
    let input = event.target;
    let value = input.value.replace(/\D/g, '');
    let formattedValue = '';

    for (let i = 0; i < value.length; i++) {
        if (i === 3 || i === 6) {
            formattedValue += '.';
        } else if (i === 9) {
            formattedValue += '-';
        }
        formattedValue += value[i];
    }

    input.value = formattedValue;
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
let maxDate = new Date(hoje.getFullYear() - 18, hoje.getMonth(), hoje.getDate());
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


