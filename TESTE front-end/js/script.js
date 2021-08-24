let tatu = document.querySelectorAll("p");
tatu[0].style.backgroundColor = "blue";

tx = document.getElementById("texto")
tx.style.color = "red";

document.getElementById("texto").innerHTML="Estou Entendendo JS";


document.write("<p style = 'color: red'>texto</p>")
document.write(50 - 5 + "<br></br>")

//prompt
/*let nome;
nome = prompt("Digite seu nome");
document.writeln("Olá " + nome);*/

let jogador = "Nicole";
let vidas = 3;
let municao = 100;
let pontos = 0;
let tiros = 1500;
let acertos = 750;
let mediaAcertos = (acertos/ tiros) * 100;

document.write("<br></br>Jogador: <span style='color: red'>" + jogador + "</span><br></br>");
document.write("Vidas: <span style='color: red'>" + vidas + "</span><br></br>");
document.write("Munição: <span style='color: red'>" + municao + "</span><br></br>");
document.write("Pontos: <span style='color: red'>" + (pontos + (vidas * 10)) + "</span><br></br>");
document.write("Média de acertos: <span style='color: red'>" + mediaAcertos + "%</span><br></br>");

let energia = 100;
let velocidade;

if ((energia > 80) && (energia <= 100)){
    document.write("Energia Alta");
    velocidade = 100;
}