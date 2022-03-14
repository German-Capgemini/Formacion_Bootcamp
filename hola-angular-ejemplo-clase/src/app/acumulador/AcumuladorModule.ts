import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { acumuladorComponent } from './acumulador.component';


@NgModule({
  declarations: [
    acumuladorComponent
  ],

  exports: [
    acumuladorComponent
  ],

  imports: [
    CommonModule
  ]
})


export class AcumuladorModule {
}
