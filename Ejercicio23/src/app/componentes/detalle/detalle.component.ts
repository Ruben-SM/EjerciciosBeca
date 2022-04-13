import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Juego } from 'src/app/entidades/juego';
import { nombre } from 'src/app/entidades/nombre';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})

export class DetalleComponent implements OnInit {

  id: number = 0
  titulo : string = ""
  compania : string = ""
  icono : string = ""
  valoracion : number = 0

  nombre : string = ""
  juego :Juego| null = null

  constructor(route:ActivatedRoute) {   
    this.id = route.snapshot.queryParams["id"]
    this.titulo = route.snapshot.queryParams["titulo"]
    this.compania = route.snapshot.queryParams["compania"]
    this.icono = route.snapshot.queryParams["icono"]
    this.valoracion = route.snapshot.queryParams["valoracion"]
    this.nombre = nombre.nombre
  }

  ngOnInit() {
  }

}

