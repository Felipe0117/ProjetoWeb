<%-- 
    Document   : TelaDados
    Created on : 21/06/2024, 14:58:33
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/TelaDados.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="menu1">
            <div class="logo"><a href="./Home"><img src="./assets/game time.jpg" class="d-block w-100" alt="..."></a></div>
            <form class="d-flex" action="buscar-produtos" method="get">
                <div class="pesquisa"><i class="fa-solid fa-magnifying-glass"></i><input type="text" id="taskPesquisa" name="busca" placeholder="Pesquisa"></div>
            <div class="itens"><button>Buscar</button></div>
            </form>
            <div class="bot" id="um"><a class="buttons" href="./ir_dados?id=${usuario.id_usuario}"><i class="fa-solid fa-user"></i></a></div>
            <div class="bot" id="dois"><a class="buttons" href="./ir_carrinho"><i class="fa-solid fa-cart-shopping"></i></a></div>                            
        </div>
            <div id="botao1" class="cats" ><button onclick="menuShow()"><i class="fa-solid fa-bars"></i></button></div>
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
            <section class="tudo">
                <div class="usuario">
                    <h2><i class="fa-solid fa-user"></i>Seus Dados</h2>
                    <div class="dados">
                        <p>Nome:</p>
                        <p class="negrito">${usuario.nome_usuario}</p>
                    </div>
                    <div class="dados">
                        <p>Nome de Usuário:</p>
                        <p class="negrito">${usuario.usuario}</p>
                    </div>
                    <div class="dados">
                        <p>Telefone:</p>
                        <p class="negrito">${usuario.telefone}</p>
                    </div>
                    <div class="dados">
                        <p>Data de Nascimento:</p>
                        <p class="negrito">${usuario.data_nascimento}</p>
                    </div>
                    <div class="dados" id="cpf">
                        <p>CPF:</p>
                        <p class="negrito">${usuario.cpf}</p>
                    </div>                     
                </div>
                <div class="hist">
                    <h2><i class="fa-solid fa-boxes-stacked"></i>Seu Histórico</h2>
                    <p class="sub">Quant</p>
                    <div class="carrinho">                      
                    <c:forEach items="${historicos}" var="historico">
                        <div class="cartao">
                            <img src="${historico.imagem_historico}" class="cartao-img" alt="${historico.nome_historico}">
                                <div class="corpo">                        
                                    <h5 class="titulos">${historico.nome_historico}</h5>
                                        <p class="valor">R$ <fmt:formatNumber value="${historico.valor_historico}" pattern="#.00" /></p>                                       
                                </div>
                            <div class="quant">
                                <p class="quantidade">${historico.quantidade_historico}</p>
                            </div>
                        </div>
                    </c:forEach>
                    </div>
                </div>                    
            </section>
                <div class="bota">
                    <div><a id="btn1" href="./Login">Sair do site</a></div>
                    <div><a id="btn2" href="./Login">Menu do Admin</a></div>
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
        <div class="rodapé">
            <p>© 2024, Game Time Store</p>
            <p id="tel">Telefone: (43) 2730-9352</p>
        </div>  
        </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    </body>
    <script src="./js/Responsividade.js"></script>
</html>
