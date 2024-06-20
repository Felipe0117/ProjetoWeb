 function excluirItem(idCarrinho, quantidadeCarrinho, produtoId3) {
    if (confirm("Deseja excluir este item do carrinho?")) {
        fetch('ExcluirItemCarrinho', {
            method: 'POST',
            body: `idCarrinho=${idCarrinho}&quantidadeCarrinho=${quantidadeCarrinho}&idProduto=${produtoId3}`
        })
    }
}


