function validarInputs() {
            var cartao = document.getElementById("cart").value;
            var cvc = document.getElementById("cvc").value;
            var dataValidade = document.getElementById("data_validade").value;
            var nome = document.getElementById("nome").value;
            
            var cartaoPattern = /^[0-9]{4}\.[0-9]{4}\.[0-9]{4}\.[0-9]{4}$/;
            var cvcPattern = /^[0-9]{3}$/;

            if (!cartaoPattern.test(cartao)) {
                alert("Número do Cartão inválido.");
                return false;
            }

            if (!cvcPattern.test(cvc)) {
                alert("CVC inválido.");
                return false;
            }

            if (dataValidade === "") {
                alert("Data de Validade é obrigatória.");
                return false;
            }

            if (nome === "") {
                alert("Nome do Titular é obrigatório.");
                return false;
            }

            return true;
        }

