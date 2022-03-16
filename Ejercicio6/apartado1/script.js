// Parte 1: Array

let array = []

function agregarNum(){

    let lista = document.getElementById("lista")
    let numero = document.getElementById("numero")
    let option = document.createElement("option")
    
    if (numero.value != ""){
        array.push(numero.value)
        option.value = numero.value
        option.text = numero.value
        lista.appendChild(option);
    }
    numero.value=""
}

function obtenerNum(){
    let numero = document.getElementById("get");
    let numAleatorio = Math.floor ( (Math.random() * array.length) )
    numero.value=array[numAleatorio]
}



