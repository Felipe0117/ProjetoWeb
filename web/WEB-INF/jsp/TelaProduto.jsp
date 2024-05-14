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
                      
                      <a href="./Produto?id=${produto.idProduto}" class="btn btn-primary" type="submit" value="comprar"Comprar>Comprar</a>
                    </div>
                  </div>
        </c:forEach>
    </body>
</html>
