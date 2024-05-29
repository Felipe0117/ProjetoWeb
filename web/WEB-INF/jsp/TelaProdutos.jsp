<%-- 
    Document   : produtos.jsp
    Created on : 15/04/2024, 15:53:01
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaProdutos.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
        <div class="menu1">
            <div class="logo"><a href="./Home">HOME</a></div>
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
            <section class="meio">
        <c:forEach items="${produtos}" var="produto">
                <div class="card" style="width: 14rem;">
                    <img src="${produto.imagem}" class="card-img-top" alt="${produto.nome}">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome}</h5>
                      <p class="card-text">R$ ${produto.valor}</p>
                      <a href="./Produto?id=${produto.idProduto}" class="btn btn-primary" type="submit" value="comprar">Comprar</a>
                    </div>
                  </div>
            </c:forEach>
            </section>
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
