import { Component, OnInit } from '@angular/core';
import { Juego } from 'src/app/entidades/juego';
import { ActivatedRoute } from '@angular/router';
import { nombre } from 'src/app/entidades/nombre';


@Component({
  selector: 'app-juegos',
  templateUrl: './juegos.component.html',
  styleUrls: ['./juegos.component.css']
})
export class JuegosComponent implements OnInit {

  logueado: boolean= nombre.logueado

  listaJuegos : Juego[] = [
    new Juego(1,"NBA 2K22","2K","assets/imagenes/nba.jpg",8),
    new Juego(2,"FIFA 22","EA Sports","assets/imagenes/fifa.jpg",8.5),
    new Juego(3,"Uncharted","Naughty Dog","assets/imagenes/uncharted.jpg",9.5),
    new Juego(4,"Gears of War","Epic Games","assets/imagenes/gears.jpg",9)
  ]
  
  juego : Juego | null = null
  nombre : string = ""

  id: number = 0
  titulo: string = ""
  icono: string = ""
  
  constructor(route:ActivatedRoute) {
    this.nombre = route.snapshot.params["nombre"]
    nombre.nombre = this.nombre
    console.log(nombre.nombre)

  }

  public seleccionar(juego : Juego) : void{
    console.log("Seleccionando...")

    this.id = juego.id
    this.titulo = juego.titulo
    this.icono = juego.icono

  }
  
  ngOnInit() {

  }
   
}
