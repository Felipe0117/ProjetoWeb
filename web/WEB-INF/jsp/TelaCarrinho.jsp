<%-- 
    Document   : TelaCarrinho
    Created on : 14/05/2024, 15:04:46
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/TelaCarrinho.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="todos">
        <header>
            <div class="menu1">
                <div class="logo"><a href="./Home"><img src="./assets/game time.jpg" class="img_log" alt="..."></a></div>
                    <form class="d-flex" action="buscar-produtos" method="get">
                        <div class="pesquisa"><i class="fa-solid fa-magnifying-glass"></i><input type="text" id="taskPesquisa" name="busca" placeholder="Pesquisa"></div>
                        <div class="itens"><button>Buscar</button></div>
                    </form>
                <div class="bot" id="um"><a class="buttons" href="./ir_dados?id=${usuario.id_usuario}"><i class="fa-solid fa-user"></i></a></div>
                <div class="bot" id="dois"><a class="buttons" href="./ir_carrinho"><i class="fa-solid fa-cart-shopping"></i></a></div>
            </div>
            <div class="cats" id="botao1"><button onclick="menuShow()"><i class="fa-solid fa-bars"></i></button></div>
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
            <h1><i class="fa-solid fa-cart-shopping"></i>Carrinho</h1>
            <div class="carta">
            <p class="valores">Quantidade</p>
            </div>
        <div class="carrinho">
            
            <c:forEach items="${carro}" var="carros">
                <div class="cartao">
                    <img src="${carros.imagemCarrinho}" class="cartao-img" alt="${carros.nomeCarrinho}">
                    <div class="corpo">                        
                        <h5 class="titulos">${carros.nomeCarrinho}</h5>
                        <p class="valor">R$ <fmt:formatNumber value="${carros.valorCarrinho}" pattern="#.00" /></p>                                       
                    </div>
                    <div class="quant">
                        <p class="quantidade">${carros.quantidadeCarrinho}</p>
                    </div>
                    <form action="ExcluirItem" method="post" enctype="multipart/form-data">
                        <div class="retirar">
                        <button class="excluir" type="submit"><p>Excluir</p></button>
                        </div>
                            <input type="hidden" name="idCarrinho" value="${carros.id_carrinho}">
                    </form>
                  </div>
            </c:forEach>
        </div>
            <c:forEach items="${totalCarrinho}" var="totalCarrinhos">
            <div class="total">
                <h2 class="palavra">Total: R$ <fmt:formatNumber value="${totalCarrinhos.total}" pattern="#.00" /></h2>               
            </div>
            </c:forEach>
            <div class="CheckOut">
                <form action="irCheckOut" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="idcarrinho" value="${carros.nomeCarrinho}" />
                    <button class="comprar" type="submit" class="btn btn-comprar">Finalizar Compra</button>
                </form>
            </div>
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
        <div class="final">
            <p>© 2024, Game Time Store</p>
            <p id="tel">Telefone: (43) 2730-9352</p>
        </div>
        </footer>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>       
        <script src="./js/AlterarCarrinho.js"></script>
    </body>
</html>
