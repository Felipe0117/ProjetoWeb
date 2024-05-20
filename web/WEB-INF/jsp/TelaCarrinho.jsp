<%-- 
    Document   : TelaCarrinho
    Created on : 14/05/2024, 15:04:46
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrinho</h1>
        <div class="carrinho">
            <c:forEach items="${produtos}" var="produto">
                <div class="card" style="width: 14rem;">
                    <img src="${produto.imagem}" class="card-img-top" alt="${produto.nome}">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome_produto}</h5>
                      <br>
                      <p class="card-text">R$ ${produto.valor}</p>
                      
                      <a href="./Produto?id=${produto.idProduto}" class="btn btn-primary" type="submit" value="comprar">Comprar</a>
                    </div>
                  </div>
            </c:forEach>
        </div>
    </body>
</html>
