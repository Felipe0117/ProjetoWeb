document.addEventListener("DOMContentLoaded", function () {
    // Seleciona o botão pelo id
    var comprarButton = document.getElementById("comprar");

    // Adiciona um event listener para o evento de clique
    comprarButton.addEventListener("click", function () {
        // Ação a ser realizada quando o botão for clicado
        Swal.fire({
  position: "top-end",
  icon: "success",
  title: "Your work has been saved",
  showConfirmButton: false,
  timer: 4000
});

    });
});


