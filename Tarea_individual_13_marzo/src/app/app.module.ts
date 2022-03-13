import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CiudadesComponent } from './ciudades/ciudades.component';
import { MesesComponent } from './meses/meses.component';
import { DiasComponent } from './dias/dias.component';
import { ComidasComponent } from './comidas/comidas.component';

@NgModule({
  declarations: [
    AppComponent,
    CiudadesComponent,
    MesesComponent,
    DiasComponent,
    ComidasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
