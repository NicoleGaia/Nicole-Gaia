function sum() {
    let num1 = document.querySelector(".num1").value;
    let num2 = document.querySelector(".num2").value;
    let result = parseFloat(num1) + parseFloat(num2);
    document.querySelector(".result").innerHTML = result;
    
}