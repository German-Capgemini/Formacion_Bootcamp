import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VistasModule } from './vistas/vistas.module';
import { MenuComponent } from './menu/menu.component';
import { ModulosPrimeModule } from './modulos-prime/modulos-prime.module';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    VistasModule,
    ModulosPrimeModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
