function valida() {
    if(document.f_aula.f_nome.value == "") {
        alert("Digitar seu nome")
        document.getElementById(f_inome).focus();
        return false;
    }
    if(document.f_aula.f_senha.value == "") {
        alert("Digite sua senha")
        document.getElementById(f_isenha).focus();
        return false;
    }
    let data = new Date();
    let dt = new Array;
    var aux = document.f_aula.f_data.value;
    dt = aux.split("/");
    if (((dt[0] < 1) || (dt[0 > 31])) || ((dt [1] < 1) || (dt[1] > 12)) ||
    ((dt[2] < dt.getFullYear() - 150) || (dt[2] > dt.getFullYear()))) {
    alert("Digite uma data válida");
    document.getElementById("f_idata").focus();
    return false;
  }
  let vm = document.f_aula.f_email.value;
  if (vm.search("@") == -1) {
    alert("Digite um email válido");
    document.getElementById("f_iemail").focus();
    return false;
  }
}