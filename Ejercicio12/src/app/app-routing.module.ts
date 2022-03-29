import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './componentes/aboutUs/aboutUs.component';
import { ContactanosComponent } from './componentes/contactanos/contactanos.component';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import { JuegosComponent } from './componentes/juegos/juegos.component';
import { LoginComponent } from './componentes/login/login.component';

const routes: Routes = [
  {
    path : '', 
    component : LoginComponent
  },{
    path : 'juegos', 
    component : JuegosComponent
  },{
    path : 'contactanos',
    component : ContactanosComponent
  },{
    path: 'aboutus',
    component : AboutUsComponent
  },{
    path: 'login',
    component : LoginComponent
  },{
    path: 'detalle',
    component: DetalleComponent
  },{
    path : 'juegos/:nombre', 
    component : JuegosComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
