import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PorCapitalComponent } from './components/por-capital/por-capital.component';
import { PorPaisComponent } from './components/por-pais/por-pais.component';
import { PorRegionComponent } from './components/por-region/por-region.component';
import { VerPaisComponent } from './components/ver-pais/ver-pais.component';
import { FormsModule } from '@angular/forms';
import { PaisTablaComponent } from './components/pais-tabla/pais-tabla.component';
import { RouterModule } from '@angular/router';
import { PaisInputComponent } from './components/pais-input/pais-input.component';



@NgModule({
  declarations: [
    PorCapitalComponent,
    PorPaisComponent,
    PorRegionComponent,
    VerPaisComponent,
    PaisTablaComponent,
    PaisInputComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports:[
    PorCapitalComponent,
    PorPaisComponent,
    PorRegionComponent,
    VerPaisComponent
  ]
})
export class PaisesModule { }
