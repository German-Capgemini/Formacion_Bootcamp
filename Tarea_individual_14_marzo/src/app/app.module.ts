import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CalcularComponent } from './calcular/calcular.component';
import { MostrarComponent } from './mostrar/mostrar.component';

@NgModule({
  declarations: [
    AppComponent,
    CalcularComponent,
    MostrarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
