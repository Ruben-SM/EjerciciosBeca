import { Component, OnInit } from '@angular/core';
import { nombre } from 'src/app/entidades/nombre';
import { Router } from "@angular/router";


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  
  constructor(private router: Router) {}  

  public volver(){
    this.router.navigate(["/juegos",nombre.nombre])
  }

  ngOnInit() {
  }

}
