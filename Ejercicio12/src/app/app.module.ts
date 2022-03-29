import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutUsComponent } from './componentes/aboutUs/aboutUs.component';
import { ContactanosComponent } from './componentes/contactanos/contactanos.component';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import { JuegoComponent } from './componentes/juego/juego.component';
import { JuegosComponent } from './componentes/juegos/juegos.component';
import { LoginComponent } from './componentes/login/login.component';
import { MenuComponent } from './componentes/menu/menu.component';

@NgModule({
  declarations: [	
    AppComponent,
    MenuComponent,
    JuegosComponent,
    JuegoComponent,
    LoginComponent,
    AboutUsComponent,
    ContactanosComponent,
    DetalleComponent
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
