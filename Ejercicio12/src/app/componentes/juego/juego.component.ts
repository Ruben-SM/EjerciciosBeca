import { Component, Input,OnInit } from '@angular/core';
import { Juego } from 'src/app/entidades/juego';


@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {

  @Input() juego : Juego;

  constructor() { }

  ngOnInit() {
  }

}
