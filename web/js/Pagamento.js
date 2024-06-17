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

