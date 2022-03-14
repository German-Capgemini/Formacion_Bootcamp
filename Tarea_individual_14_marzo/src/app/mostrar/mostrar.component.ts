import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-mostrar',
  templateUrl: './mostrar.component.html',
  styles: [
  ]
})
export class MostrarComponent  {

  @Input() variableResultado:any;




}
