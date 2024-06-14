<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaCheckOut.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1><i class="fa-solid fa-tag"></i>Finalizar Compra</h1>
        </header>
        <main>
            <div class="compra">
                <h2><i class="fa-solid fa-bag-shopping"></i>Itens</h2>
                <div class="carrinho">
            <c:forEach items="${carro}" var="carros">
                <div class="cartao">
                    
                    <img src="${carros.imagemCarrinho}" class="cartao-img" alt="${carros.imagemCarrinho}">
                    <div class="corpo">
                        <h5 class="titulos">${carros.nomeCarrinho}</h5>
                        <p class="valor">R$ ${carros.valorCarrinho}</p>
                    </div>
                    
                    <div class="quant">
                        <p class="quantidade">${carros.quantidadeCarrinho}</p>
                    </div>
                </div>
            </c:forEach>
                    </div>
                  </div>               
            <div class="endereco">
                
            </div>
            <div class="forma_pagamento">
                
            </div>
            
        </main>
        <footer>
            <div class="fim">
                <p>© 2024, Game Time Store</p>
                <p id="tel">Telefone: (43) 2730-9352</p>
            </div>            
        </footer>     
    </body>
</html>
