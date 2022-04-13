import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entidades/usuario';
import { Router } from "@angular/router";
import { nombre } from 'src/app/entidades/nombre';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit() {
  }

  nombre : string = ""
  password: string = ""
  listaUsuarios: Usuario[] = []

  MostrarErrorUsuario: boolean = false;

  private _httpClient : HttpClient
  readonly url = 'http://localhost:8080/Ejercicio21/usuarios/login'

  constructor( private router: Router) {
    nombre.nombre = ""
    nombre.logueado = false
  }

  public async login(){
    await fetch(`${this.url}?nombre=${this.nombre}&password=${this.password}`,{mode: 'cors'})
    .then(v => v.json())
    .then(v => {
      if(JSON.parse(v.validado)){
        nombre.nombre = this.nombre
        nombre.logueado = true
        this.router.navigate(["/juegos",this.nombre])
      }else{
        this.MostrarErrorUsuario = true
      }
    });
  }

}
