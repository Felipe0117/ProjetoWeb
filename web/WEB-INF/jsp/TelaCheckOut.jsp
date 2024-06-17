<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaCheck-Out.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1><i class="fa-solid fa-tag"></i>Finalizar Compra</h1>
        </header>
        <main>
            <section class="tudo">
            <div class="compra">
                <h2><i class="fa-solid fa-bag-shopping"></i>Itens</h2>
                <div class="carrinho">
            <c:forEach items="${carro}" var="carros">
                <div class="prod">
                    
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
                <h2><i class="fa-solid fa-truck-fast"></i></i>Endereço</h2>
                <div class="dados_ender">                   
                        <p>Rua</p>
                        <input name="rua" type="text" id="nome_usuario" placeholder="" required>
                        <p>Número</p>
                        <input name="numero" type="number" id="numero" placeholder="" required>
                        <p>CEP</p>
                        <input name="cep" type="number" id="cep" placeholdenumeror="" required>
                        <p>Cidade</p>
                        <input name="cidade" type="text" id="cidade" placeholder="" required>
                        <div class="bot">
                        <button class="salvar" type="submit">Salvar Endereço</button>
                        </div>
                </div>               
            </div>
            <div class="forma_pagamento">
                <h2><i class="fa-regular fa-credit-card"></i></i>Forma de Pagamento</h2>
                <div class="radio-inputs">
		<label>
			<input class="radio-input" type="radio" name="engine" value="credito">
				<span class="radio-tile">
					<span class="radio-icon">
						<i class="fa-solid fa-credit-card"></i>
                                        </span>
					<span class="radio-label">Crédito</span>
				</span>
		</label>
		<label>
			<input checked="" class="radio-input" type="radio" name="engine" value="debito">
			<span class="radio-tile">
				<span class="radio-icon">
                                    <i class="fa-regular fa-credit-card"></i>
                                </span>
				<span class="radio-label">Débito</span>
			</span>
		</label>
		<label>
			<input class="radio-input" type="radio" name="engine" value="pix">
			<span class="radio-tile">
				<span class="radio-icon">
                                    <i class="fa-brands fa-pix"></i>
                                </span>
				<span class="radio-label">Pix</span>
			</span>
		</label>
                </div>
                <section class="opcao">
                    <div id="credito" class="content-div">
                        <p>Número do Cartão:</p>
                        <input name="cartao" type="number" id="cartao" placeholder="" required>
                        <div class="org">
                            <div class="cvcs">
                                <p>CVC:</p>
                                <input name="cvc" type="number" id="cvc" placeholder="" required>
                            </div>
                            <div class="val">
                                <p>Data de Validade:</p>
                                <input name="data_validade" type="date" id="data_validade" placeholder="" required>
                            </div>
                        </div>
                        <p>Nome do Titular:</p>
                        <input name="nome" type="text" id="nome" placeholder="" required>
                    </div>
                    <div id="debito" class="content-div">
                        <p>Número do Cartão:</p>
                        <input name="cartao" type="number" id="cartao" placeholder="" required>
                        <div class="org">
                            <div class="cvcs">
                                <p>CVC:</p>
                                <input name="cvc" type="number" id="cvc" placeholder="" required>
                            </div>
                            <div class="val">
                                <p>Data de Validade:</p>
                                <input name="data_validade" type="date" id="data_validade" placeholder="" required>
                            </div>
                        </div>
                        <p>Nome do Titular:</p>
                        <input name="nome" type="text" id="nome" placeholder="" required>
                    </div>
                    <div id="pix" class="content-div">
                        <p>Conteúdo para Pix</p>
                    </div> 
                </section>
            </div>
        </section>
            <button class="finalizar">Finalizar Compra</button>
        </main>
        <footer>
            <div class="fim">
                <p>© 2024, Game Time Store</p>
                <p id="tel">Telefone: (43) 2730-9352</p>
            </div>            
        </footer>
        
    </body>
    <script src="./js/Pagamento.js" type="text/javascript"></script>
        
</html>
