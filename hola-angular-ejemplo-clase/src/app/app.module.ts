import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { acumuladorComponent } from './acumulador/acumulador.component';

import { AppComponent } from './app.component';
import { HeroesComponent } from './heroe/heroes/heroes.component';
import { ListadoComponent } from './heroe/listado/listado.component';

@NgModule({
  declarations: [
    AppComponent,
    acumuladorComponent,
    HeroesComponent,
    ListadoComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
