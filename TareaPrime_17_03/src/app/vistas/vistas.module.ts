import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModulosPrimeModule } from '../modulos-prime/modulos-prime.module';
import { SobreMiComponent } from './sobre-mi/sobre-mi.component';
import { MiExperienciaComponent } from './mi-experiencia/mi-experiencia.component';
import { ContactoComponent } from './contacto/contacto.component';
import { PortfolioComponent } from './portfolio/portfolio.component';



@NgModule({
  declarations: [
    SobreMiComponent,
    MiExperienciaComponent,
    ContactoComponent,
    PortfolioComponent
  ],
  imports: [
    CommonModule,
    ModulosPrimeModule
  ],
  exports:[
    SobreMiComponent,
    MiExperienciaComponent,
    ContactoComponent
  ]
})
export class VistasModule { }
