import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entidades/usuario';
import { Router } from "@angular/router";
import { nombre } from 'src/app/entidades/nombre';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit() {
  }

  nombre : string = ""
  pass: string = ""
  listaUsuarios: Usuario[] = []

  MostrarErrorNombre: boolean = false;
  MostrarErrorPass: boolean = false;
   
  constructor(private router: Router) {
    this.listaUsuarios.push( new Usuario("Pepe","1234"))
    this.listaUsuarios.push( new Usuario("Ana","2468"))
    this.listaUsuarios.push( new Usuario("Leo","6789"))
    nombre.nombre = ""
    nombre.logueado = false
    console.log(nombre.nombre)
  }

  /**
   * Funcion que comprueba si el campo nombre de usuario introducido coincide con alguno existente del array
   * @returns TRUE si hay algun usuario con el nombre introducido, FALSE en caso contrario
   */

  public usuarioExiste():boolean {
    for (let i = 0; i < this.listaUsuarios.length; i++) {
      if (this.nombre == this.listaUsuarios[i].nombre){
        return true
      }
    }
    return false
  }

  /**
   * Funcion que comprueba si el campo contraseña introducido coincide con alguno existente del array
   * @returns TRUE si hay algun usuario con la contraseña introducida, FALSE en caso contrario
   */

  public passValido(): boolean{
    if (this.usuarioExiste()){
      for (let i = 0; i < this.listaUsuarios.length; i++) {
        if (this.pass == this.listaUsuarios[i].pass && this.nombre == this.listaUsuarios[i].nombre){
          return true
        }
      }
    }

    return false
  }


  /**
   * Funcion que comprueba si el usuario introducido es valido
   * @returns 0 si el usuario ha sido validado, 1 si el nombre es correcto pero la contraseña no ha sido valida, 2 si el nombre no existe
   */

  public usuarioValido():number{
    if (this.usuarioExiste()){
      if(this.passValido()){
        return 0 
      }else{
        return 1
      }
    }else{
      return 2
    }
  }

  /**
   * Funcion que cambia de pagina si los datos son correctos, en caso contrario vuelve visible el error correspondiente
   */

  public entrar(){
    switch (this.usuarioValido()){
      case 0:
        this.router.navigate(["/juegos",this.nombre])
        this.MostrarErrorPass = false;
        this.MostrarErrorNombre = false;
        nombre.logueado = true
        break
      case 1:
        this.MostrarErrorPass = true;
        this.MostrarErrorNombre = false;
        break
      case 2:
        this.MostrarErrorPass = false;
        this.MostrarErrorNombre = true;
        break
    }

  }




}
