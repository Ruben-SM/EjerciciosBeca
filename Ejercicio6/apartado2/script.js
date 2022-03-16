// Parte 2: Calculadora 

let operando1,operando2,resultado

function obtenerDatos(){
    operando1 = document.getElementById("n1").value
    operando2 = document.getElementById("n2").value
    resultado = document.getElementById("resultado")

    if (operando1== "" )
        operando1= 0
    else
        operando1 = parseInt(operando1)

    if (operando2== "" )
        operando2 = 0
    else
        operando2 = parseInt(operando2)    
}

function sumar(){
    obtenerDatos()

    let res = operando1 + operando2
    resultado.value = res;
}
function restar(){
    obtenerDatos()

    let res = operando1 - operando2
    resultado.value = res;
}
function multiplicar(){
    obtenerDatos()

    let res = operando1 * operando2
    resultado.value = res;
}
function dividir(){
    obtenerDatos()

    let res = operando1 / operando2
    resultado.value = res;
}

