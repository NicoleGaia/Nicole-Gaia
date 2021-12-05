function fazGet(url){
    let request = new XMLHttpRequest()
    request.open("GET", url, false)
    request.send()
    return request.responseText
}

function criaLinha(cliente){
    //cria linha
    linha = document.createElement("tr");

    //cria elemento linha
    tdIdCliente = document.createElement("td");
    tdNome = document.createElement("td");
    tdCpfOuCnpj = document.createElement("td");
    tdTipo = document.createElement("td");
    tdEmail = document.createElement("td");
    tdTelefones = document.createElement("td");

    //criando o HTML
    tdIdCliente.innerHTML = cliente.idCliente
    tdNome.innerHTML = cliente.nome
    tdCpfOuCnpj.innerHTML = cliente.cpfOuCnpj
    tdTipo.innerHTML = cliente.tipo
    tdEmail.innerHTML = cliente.email
    tdTelefones.innerHTML = cliente.telefones
    
    //add como filho a cada uma que vier
    linha.appendChild(tdIdCliente);
    linha.appendChild(tdNome);
    linha.appendChild(tdCpfOuCnpj);
    linha.appendChild(tdTipo);
    linha.appendChild(tdEmail);
    linha.appendChild(tdTelefones);

    return linha;
}

function main(){
    let data = fazGet("http://localhost:8080/clientes")
    let clientes = JSON.parse(data);
    console.log(clientes);

    let tabela = document.getElementById("tabela")
    clientes.forEach(element =>{
    let linha = criaLinha(element);
    tabela.appendChild(linha);
})
}
main();
