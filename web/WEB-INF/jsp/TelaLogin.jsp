<%-- 
    Document   : telaLogin
    Created on : 08/04/2024, 16:39:14
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/TelaLogin.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <nav class="imagem"></nav>
            <div class="login">
                <h1>Login</h1>
                <form action="logar" name="frmLogin">
                <div class="teste">
                    <i class="fa-solid fa-user"></i><input type="text" id="username" placeholder="Nome do usuário ">
                </div>
                <br>
                <br>
                <div class="teste">
                    <i class="fa-solid fa-lock"></i><input type="text" id="password" placeholder="Senha">
                </div>
                <br>
                <br>
                <button id="entrarTask" type="submit">Entrar</button>
                <div><a href="./Home">Teste</a></div>
                <div class="cadastro"><span>Não possui conta? </span><a href="./Cadastro"> Cadastre-se</a></div>
                </form>
            </div>
        </div>
    </body>
</html>
