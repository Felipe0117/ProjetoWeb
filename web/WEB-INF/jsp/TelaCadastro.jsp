
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/TelaCadastro.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">           
        <h1>Cadastro</h1>
        <form action="cadastrar"  method="post">
            <div class="teste">
                <i class="fa-solid fa-user"></i><input name="nome_usuario" type="text" id="nome_usuario" placeholder="Nome">
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-lock"></i><input name="senha" type="text" id="senha" placeholder="Senha">
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-user-check"></i><input name="user" type="text" id="user" placeholder="Nome de Usuário">
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-phone"></i><input name="telefone" type="text" id="telefone" placeholder="Telefone">
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-regular fa-address-card"></i><input name="cpf" type="text" id="cpf" placeholder="CPF">
            </div>
            <br>
            <br>
            <button id="criarTask" type="submit">Criar</button>
            </form>
    </div>
        
    </body>
</html>
