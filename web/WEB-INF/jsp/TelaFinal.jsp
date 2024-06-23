<%-- 
    Document   : TelaFinal
    Created on : 22/06/2024, 21:13:45
    Author     : felip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaFinal.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div></div>
        </header>
        <main>
            <section class="tudo">
            <h1>Sua compra foi finalizada com sucesso!</h1>
            <h2>Obrigado por comprar na GameTime</h2>
            <div class="img"></div>
            <div class="botoes">
                <a href="./Home" class="btn"><p>Continuar comprando</p></a>
                <a href="./ir_dados?id=${usuario.id_usuario}" class="btn"><p>Histórico de compras</p></a>
                <a href="./Login" class="btn"><p>Sair</p></a>
            </div>
            </section>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
