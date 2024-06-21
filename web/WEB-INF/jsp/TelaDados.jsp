<%-- 
    Document   : TelaDados
    Created on : 21/06/2024, 14:58:33
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
        <header>
            
            <p>Login ${usuario.nome_usuario}</p>
        </header>
        <main>
            <div class="dados">
            
            <c:forEach items="${historicos}" var="historico">
                <div class="cartao">
                    <img src="${historico.imagem_historico}" class="cartao-img" alt="${historico.nome_historico}">
                    <div class="corpo">                        
                        <h5 class="titulos">${historico.nome_historico}</h5>
                        <p class="valor">R$ ${historico.valor_historico}</p>                                       
                    </div>
                    <div class="quant">
                        <p class="quantidade">${historico.quantidade_historico}</p>
                    </div>
                  </div>
            </c:forEach>
        </div>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
