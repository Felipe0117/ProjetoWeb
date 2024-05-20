<%-- 
    Document   : TelaProduto
    Created on : 15/04/2024, 16:33:15
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${produtos}" var="produto">
                <div class="card" style="width: 18rem;">
                    <img src="${produto.imagem}" class="card-img-top" alt="${produto.nome}">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome_produto}</h5>
                      <br>
                      <p class="card-text">R$ ${produto.valor}</p>
                      
                      <button type="submit" class="btn btn-comprar"  idProduto="${produto.idProduto}" imagem="${produto.imagem}" nome="${produto.nome}" descricao="${produto.descricao}"  valor="${produto.valor}"
                              quantidade=1 id="comprar">Adicionar ao Carrinho</button>
                    </div>
                  </div>
        </c:forEach>
        <form id="form-comprar" action="enviarItemCarrinho" method="post" enctype="multipart/form-data" style="display: none;">
            <input type="hidden" name="idProduto" id="idProduto">
            <input type="hidden" name="descricao" id="descricao">
            <input type="hidden" name="nome" id="nome">
            <input type="hidden" name="valor" id="valor">
            <input type="file" name="imagem" id="imagem">
            <input type="hidden" name="quantidade" id="quantidade">           
        </form>
    </body>
    <script src="./js/Carrinho.js"></script>
</html>
