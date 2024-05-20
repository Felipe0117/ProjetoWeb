document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function() {
        var idProduto = this.getAttribute('idProduto');
        var imagem = this.getAttribute('imagem');
        var nome = this.getAttribute('nome');
        var valor = this.getAttribute('valor');
        var descricao = this.getAttribute('descricao');
        var quantidade = this.getAttribute('quantidade');      


 
          // Crie um novo objeto FormData
        var formData = new FormData();
       
        // Adicione os dados do produto ao FormData
        formData.append('produto_id3', idProduto);
        formData.append('nome_produto_carrinho', nome);
        formData.append('valor_produto_carrinho', valor);
        formData.append('descricao_produto_carrinho', descricao);
        formData. append('quantidade_carrinho',quantidade);
        formData.append('imagem_produto_carrinho', imagem);
       
        // Envie o FormData
        fetch('enviarItemCarrinho', {
            method: 'POST',
            body: formData
        })
   
            .then(response => {
        if (!response.ok) {
                throw new Error('Ocorreu um erro ao enviar o formulário.');
            }else{
                alert('Compra feita com sucesso.');
                window.location.href = './Home';
            }  
        })
        .catch(error => {
            console.error('Erro:', error);
        });
    });
});


