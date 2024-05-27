<%-- 
    Document   : TelaCarrinho
    Created on : 14/05/2024, 15:04:46
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaCarrinho.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="carrinho">
            <h1><i class="fa-solid fa-cart-shopping"></i>Carrinho</h1>
            <c:forEach items="${carro}" var="carros">
                <div class="cartao">
                    <img src="" class="cartao-img" alt="${carros.nomeCarrinho}">
                    <div class="corpo">
                        
                            <h5 class="titulo">${carros.nomeCarrinho}</h5>
                            <p class="valor">R$ ${carros.valorCarrinho}</p>
                        

                      
                                        
                    </div>
                        <p class="quantidade">${carros.quantidadeCarrinho}</p>
                  </div>
            </c:forEach>
        </div>
    </body>
</html>
