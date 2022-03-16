// Apartado 1 calificacion

let parcial1 : number = 6.5;
let parcial2 : number = 7;
let parcial3 : number = 4;

let exFinal : number = 5.5;
let trabFinal: number = 8.5;

function calificacionParcial(p1:number, p2:number, p3:number){
    let media = (p1 + p2 + p3) / 3
    return media * 0.55 
}

function calificacionFinal(){
    let notaParcial = calificacionParcial(parcial1,parcial2,parcial3)
    let notaExFinal = exFinal * 0.3
    let notaTrabjFinal = trabFinal * 0.15

    return notaParcial + notaExFinal + notaTrabjFinal
}

console.log("la calificacion final del alumno es "+calificacionFinal())
console.log()

// Apartado 2 Array

let array: Array<String> = ["GTA", "Mario Kart", "Dark Souls", "Super Mario Bros", "God of War"]

console.log("Los juegos introducidos en el Array sin nombre de Mario son:")
for (var i = 0; i < array.length; i++) {
    if (!array[i].includes("Mario"))
    console.log(array[i])
}
console.log()

// Apartado 3 Factorial

function factorial(n:number){
    if ((n == 0) || (n == 1)){
        return 1
    }else{
        return n * factorial(n-1)
    }
}

console.log("el factorial de 5 es "+ factorial(5))
