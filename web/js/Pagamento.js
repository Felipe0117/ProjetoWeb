const CepInput = (event) => {
    let input = event.target; // Pega o que esta no input em que está o onkeyup="CepMascara(event)"
    input.value = CepMascara(input.value); // Aplica a CepMascara ao valor do campo de entrada
}



const CepMascara = (value) => {
    if (!value) return ""; // Retorna uma string vazia se o valor for nulo ou indefinido
    value = value.replace(/\D/g, ""); // Remove todos os caracteres não numéricos
    value = value.replace(/(\d{5})(\d{1,3})$/, "$1-$2"); // Insere o traço após os cinco digitos(numero)
    return value; // Retorna o valor formatado com a máscara de CEP
};


document.addEventListener('DOMContentLoaded', function() {
        const radioInputs = document.querySelectorAll('.radio-input');
        const contentDivs = document.querySelectorAll('.content-div');

        function showDiv(value) {
            contentDivs.forEach(div => {
                if (div.id === value) {
                    console.log("s");
                    div.style.display = 'block';
                } else {
                    console.log("n");
                    div.style.display = 'none';
                }
            });
        }

        // Inicializa a exibição com o input selecionado
        const selectedInput = document.querySelector('.radio-input:checked');
        if (selectedInput) {
            showDiv(selectedInput.value);
        }

        radioInputs.forEach(input => {
            input.addEventListener('click', function() {
                showDiv(input.value);
            });
        });
    });

