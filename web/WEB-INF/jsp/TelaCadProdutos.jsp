<%-- 
    Document   : TelaCadProdutos
    Created on : 06/05/2024, 13:57:46
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de Produtos</title>
        <link rel="stylesheet" href="styles/TelaCadProdutos.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="tudo">
       <div class="container">
        <h1>Cadastro de Produto</h1>
        <form action="cadastrarProduto" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nome_produto">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <section class="ambos">
                <div class="form-group" id="categoria">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="mercadinho" name="mercadinho">
                    <option value="1">Celulares</option>
                    <option value="2">Monitores</option>
                    <option value="3">Peças</option>
                    <option value="4">Acessórios</option>
                    <option value="5">Gabinetes</option>
                    <option value="6">Cadeiras</option>
                    <option value="7">Headsets</option>
                </select>
            </div>           
            <div class="form-group" id="mudarValor">
                <label for="valor">Valor:</label>
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>
            </section>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
            </div>
            <div class="form-group" id="estoque">
                <label for="descricao">Estoque</label>
                <input type="number" step="0.01" class="form-control" id="estoque" name="estoque" required>
            </div>
            <div class="form-group">
                <label for="imagem">Imagem do Produto:</label>
                <input type="file" class="form-control-file" id="imagem" name="imagem">
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
     </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
