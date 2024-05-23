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
        <link rel="stylesheet" href="styles/TelaProduto.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
    <header>
        <div class="menu1">
            <div class="logo"></div>
            <form class="d-flex" action="buscar-produtos" method="get">
                <div class="pesquisa"><i class="fa-solid fa-magnifying-glass"></i><input type="text" id="taskPesquisa" name="busca" placeholder="Pesquisa"></div>
            <div class="itens"><button>Buscar</button></div>
            </form>
            <div class="bot" id="um"><a class="buttons" href="./cadastrar-produto"><i class="fa-solid fa-user"></i></a></div>
            <div class="bot"><a class="buttons" href="./ir_carrinho"><i class="fa-solid fa-cart-shopping"></i></a></div>
        </div>
           <div class="menu2">
           <div class="container container-categorias">
               <div class="ver">
                    <c:forEach items="${categoria}" var="mercadinho1" >
                        <div class="categoria">
                            <a href="./buscar-produtos?cat=${mercadinho1.idCategoria}&busca=">${mercadinho1.nome}</a>
                        </div>
                    </c:forEach>
                </div>
           </div>
           </div>
    </header>
    <main>
        <c:forEach items="${produtos}" var="produto">
                <div class="cartao">
                    <div class="body1">
                        <img src="${produto.imagem}" class="produto" alt="${produto.nome}">
                    </div>
                    <div class="body">
                      <h5 class="title">${produto.nome}</h5>
                      <p class="cartao-text">${produto.descricao}</p>
                      <br>
                      <p class="text">R$ ${produto.valor}</p>
                      
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
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>       

    </body>
    <script src="./js/Carrinho.js"></script>
</html>
