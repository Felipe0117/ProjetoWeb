const CepInput = (event) => {
    let input = event.target; // Pega o que esta no input em que está o onkeyup="CepMascara(event)"
    input.value = CepMascara(input.value); // Aplica a CepMascara ao valor do campo de entrada
};



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
            contentDivs.forEach(div => { //inicia a função para cada elemento da classe ".content-div"
                if (div.id === value) { //se o id do .content-div for igual ao value do .radio-input a div que possui essas características deverá aparecer
                    console.log("s");
                    div.style.display = 'block';
                } else {
                    console.log("n");
                    div.style.display = 'none';
                }
            });
        }

        
        const selectedInput = document.querySelector('.radio-input:checked'); // checked recebe o valor do input que está sendo selecionado
        if (selectedInput) {
            showDiv(selectedInput.value); //esse if está sendo utilizado para quando a página carrega com uma opção já marcada 
        }

        radioInputs.forEach(input => { //para cada vez que um input da classe ".radio-input" for clicado a função showDiv será rodada
            input.addEventListener('click', function() {
                showDiv(input.value);
            });
        });
    });

