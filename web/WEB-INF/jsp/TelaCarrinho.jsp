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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrinho</h1>
        <div class="carrinho">
            <c:forEach items="${carro}" var="carros">
                <div class="card" style="width: 14rem;">
                    <img src="${carros.imagemCarrinho}" class="card-img-top" alt="${carros.nomeCarrinho}">
                    <div class="card-body">
                      <h5 class="card-title">${carros.nomeCarrinho}</h5>
                      <br>
                      <p class="card-text">R$ ${carros.valorCarrinho}</p>
                                        
                    </div>
                  </div>
            </c:forEach>
        </div>
    </body>
</html>
