import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entidades/usuario';
import { Router } from "@angular/router";
import { nombre } from 'src/app/entidades/nombre';
import { HttpClient } from '@angular/common/http';
import { UsuarioService } from 'src/app/servicios/login.service';

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

  
  readonly url = 'http://localhost:8080/Ejercicio21/usuarios/login'

  constructor( private router: Router, private _loginService: UsuarioService) {
    nombre.nombre = ""
    nombre.logueado = false
    
  }

  public login(){
    this._loginService
    .login(this.nombre,this.password)
    .subscribe((respuesta) =>{
      if(respuesta.validado){
        nombre.nombre = this.nombre
        nombre.logueado = true
        this.router.navigate(["/juegos",this.nombre])
      }else{
        this.MostrarErrorUsuario = true
      }
    });
  }

}
