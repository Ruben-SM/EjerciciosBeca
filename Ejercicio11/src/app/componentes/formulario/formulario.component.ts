import { Component, OnInit, ViewRef } from '@angular/core';
import { Videojuego } from 'src/app/entidades/videojuego';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  videojuego :  Videojuego | null = null
  listaVideojuegos: Videojuego[] = []

  //Habilitar o deshabilitar mensajes de error 
  //El titulo, compañia y valoracion media no pueden estar vacios
  tituloObligatorioOculto = true
  companiaObligatorioOculto = true
  valoracionObligatorioOculto = true

  //Datos que recogeremos del formulario
  id : number = 0
  titulo : String = ""
  compania : String = ""
  valoracion : number = 0

  constructor() { 
    this.videojuego = new Videojuego("Elden Ring","From Software",9)
    this.listaVideojuegos.push(this.videojuego)
  }

  public hayErroresEnFormulario():boolean{
    let error : boolean = false

    if(this.titulo.trim().length == 0){
      this.tituloObligatorioOculto = false
      error = true
    }

    if(this.compania.trim().length == 0){
        this.companiaObligatorioOculto = false
        error = true
        
    }

    return error
  }

  public ocultarMensajesError(){
    this.tituloObligatorioOculto = true
    this.companiaObligatorioOculto = true
  }


  public insertar(){
    if(!this.hayErroresEnFormulario()){
      this.videojuego = new Videojuego(this.titulo, this.compania, this.valoracion)
      this.listaVideojuegos.push(this.videojuego)
      console.log(`Insertando Videojuego: ${this.videojuego.toString()}`)
      this.vaciar()
      console.log ("Videojuego insertado")
    }
  }

  public modificar(){
    if(!this.hayErroresEnFormulario()){
      for(let i=0; i<this.listaVideojuegos.length; i++){
        let aux : Videojuego = this.listaVideojuegos[i]
        if(aux.id == this.id){
          this.listaVideojuegos[i].titulo = this.titulo
          this.listaVideojuegos[i].compania = this.compania
          this.listaVideojuegos[i].valoracion = this.valoracion
          break
        }
      }
      //Evitamos null pointer con '?', en este caso se mostraría undefined
      //Con '?' hacemos acceso seguro, si no lo pondemos daría error de compilación
      console.log("Modificando... " + this.videojuego?.toString())
      this.vaciar()
    }
  }

  public borrar(){
    for(let i=0; i<this.listaVideojuegos.length; i++){
      if( this.listaVideojuegos[i].id == this.id){
        this.listaVideojuegos.splice(i,1)
        break;
      }
    }
    this.vaciar()
    console.log("Borrando... " + this.id + "quedan  "+this.listaVideojuegos.length+ "elementos")
  }

  public vaciar(){
    console.log("Vaciando...")     
    this.id = 0
    this.titulo = ""
    this.compania = ""
    this.valoracion = 0

    this.ocultarMensajesError()
  }

  public seleccionar(v : Videojuego) : void{
    console.log("Seleccionando...")
    this.ocultarMensajesError()

    this.id = v.id
    this.titulo = v.titulo
    this.compania = v.compania
    this.valoracion = v.valoracion
  }

  ngOnInit() {
  }

}
