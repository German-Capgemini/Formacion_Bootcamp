import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { DorsalNombresJugadoresPipe } from './dorsal-nombres-jugadores.pipe';


@NgModule({
  declarations: [
    AppComponent,
    DorsalNombresJugadoresPipe

  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
