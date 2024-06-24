function menuShow() {    
    let menuMobile = document.querySelector('.menu2');
    if (menuMobile.classList.contains('open')){
        menuMobile.classList.remove('open');
        document.getElementById("modoMob").style.display = 'grid';
    }else{
        menuMobile.classList.add('open');
        document.getElementById("modoMob").style.display = 'none';

    }
}

