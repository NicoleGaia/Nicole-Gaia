function cumprimento(){
    let data = new Date();
    let hora = data.getHours();
    if((hora >= 6) && (hora <= 12)) {
        alert("Bom Dia");
    }
    else if ((hora > 12) && (hora< 18)) {
        alert("Boa Tarde");
    }
    else if (hora >= 18) {
        alert("Boa Noite");
    }
}

function msg1() {
    alert("Você clicou no botão")
}

function msg2() {
    alert("Você passou pelo botão")
}