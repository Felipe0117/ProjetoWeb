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
            <div class="logo"><a href="./Home"><img src="./assets/game time.jpg" class="log" alt="..."></a></div>
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
        <form action="enviarItemCarrinho" method="post" enctype="multipart/form-data">
        <c:forEach items="${produtos}" var="produto">
                <div class="cartao">
                    <div class="body1">
                        <img src="${produto.imagem}" class="produto" alt="${produto.nome_produto}">
                    </div>
                    <div class="corpo">
                      <h5 class="titulo">${produto.nome_produto}</h5>
                      <br>
                      <br>
                      <div class="juntos">
                          <p class="quant">Quantidade:</p>
                          <input type="number" min="1" max="5" name="quantidade" id="quantidade">                                                               
                     </div>
                      <br>
                      <p class="gui">Valor a vista:</p>
                      <p class="valor">R$ ${produto.valor}</p>
                      
                      <button type="submit" class="btn btn-comprar" id="comprar">Adicionar ao Carrinho</button>
                    </div>
                  </div>
                   <p class="desc">Descrição:</p>
                   <p class="texto">${produto.descricao}</p>           
             
                   <input type="hidden" name="idProduto" id="idProduto" value="${produto.idProduto}">
                   <input type="hidden" name="descricao" id="descricao" value="${produto.descricao}">
                   <input type="hidden" name="nome" id="nome" value="${produto.nome_produto}">
                   <input type="hidden" name="valor" id="valor" value="${produto.valor}">
                   <input type="hidden" name="imagem" id="imagem" value="${produto.imagem}">
        </c:forEach>                 
        </form>
    </main>
    <footer>
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
        <div class="rodapé">
            <p>© 2024, Game Time Store</p>
            <p id="tel">Telefone: (43) 2730-9352</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>       
    </body>
</html>
