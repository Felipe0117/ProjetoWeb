
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./styles/TelaCad.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">           
        <h1>Cadastro</h1>
        <form action="cadastrar"  method="post">
            <div class="teste">
                <i class="fa-solid fa-user"></i><input name="nome_usuario" type="text" id="nome_usuario" placeholder="Nome" required>
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-lock"></i><input name="senha" type="password" id="senha" placeholder="Senha" required>
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-user-check"></i><input name="user" type="text" id="user" placeholder="Nome de Usuário" required>
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-phone"></i><input name="telefone" type="tel" id="telefone" placeholder="Telefone" oninput="maskTelefone(event)" minlength="15" maxlength="15" required>
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-solid fa-calendar-days"></i><input name="data_nascimento" type="date" id="data_nascimento" placeholder="Data de Nascimento" min="1900-01-01" max="2024-12-31" pattern="\d{4}-\d{2}-\d{2}" required>
            </div>
            <br>
            <br>
            <div class="teste">
                <i class="fa-regular fa-address-card"></i><input name="cpf" type="text" id="cpf" placeholder="CPF" oninput="maskCPF(event)" minlength="14" maxlength="14" required>
            </div>
            <br>
            <br>
            <button id="criarTask" type="submit" onclick="cadastro()">Criar</button>
            </form>
    </div>
            
    </body>
        <script src="./js/Cadastro.js" type="text/javascript"></script>
</html>
