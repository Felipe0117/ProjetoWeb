<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/TelaPrincipal.css">
        <script src="https://kit.fontawesome.com/676974c9dc.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>
        <header>
        <div class="menu1">
            <div class="itens" id="Sumir"><button></button></div>
            <div class="senai"></div>
            <div class="pesquisa"><i class="fa-solid fa-magnifying-glass"></i><input type="text" id="taskPesquisa" placeholder="Pesquisa"></div>
            <div class="itens"><button>Buscar</button></div>
        </div>
        <div class="menu2">
            <div><a href="#"><i class="fa-solid fa-camera"></i>Filmadoras</a></div>
            <div><a href="#"><i class="fa-solid fa-gamepad"></i>Games</a></div>
            <div><a href="#"><i class="fa-solid fa-desktop"></i>Notebooks</a></div>
            <div><a href="#"><i class="fa-solid fa-gears"></i>Peças</a></div>
            <div><a href="#"><i class="fa-solid fa-computer-mouse"></i>Acessórios</a></div>
            <div><a href="#"><i class="fa-solid fa-tv"></i>TVs</a></div>
            <div><a href="#"><i class="fa-solid fa-money-bill"></i>Promoções</a></div>
        </div>
    </header>
    <main>
        <div id="carouselExampleIndicators" class="carousel slide">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="assets/imagem1.png" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="assets/imagem2.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="assets/imagem3.jpg" class="d-block w-100" alt="...">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    </main>
    <footer>
        <div class="caixa">
        <div class=""><button><a href="#"><i class="fa-solid fa-arrow-up"></i></a></button></div>
        <div class="menu3">
            <div><a href="#"><i class="fa-solid fa-camera"></i>Filmadoras</a></div>
            <div><a href="#"><i class="fa-solid fa-fire-burner"></i>Eletrodomésticos</a></div>
            <div><a href="#"><i class="fa-solid fa-desktop"></i>Notebooks</a></div>
            <div><a href="#"><i class="fa-solid fa-gears"></i>Peças</a></div>
            <div><a href="#"><i class="fa-solid fa-computer-mouse"></i>Acessórios</a></div>
            <div><a href="#"><i class="fa-solid fa-tv"></i>TVs</a></div>
            <div><a href="#"><i class="fa-solid fa-money-bill"></i>Promoções</a></div>
        </div> 
    </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>       
    </body>
</html>
