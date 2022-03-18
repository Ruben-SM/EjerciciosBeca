import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  //Datos que recogeremos del formulario
  n1 : number = 0
  n2 : number = 0
  resultado : number = 0

  constructor() { }

  public sumar(){
    this.resultado = this.n1 + this.n2
  }

  public restar(){
    this.resultado = this.n1 - this.n2
  }

  public multiplicar(){
    this.resultado = this.n1 * this.n2
  }

  public dividir(){
    this.resultado = this.n1 / this.n2
  }

  ngOnInit() {
  }

}
