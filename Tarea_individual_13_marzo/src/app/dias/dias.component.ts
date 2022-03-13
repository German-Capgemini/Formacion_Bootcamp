import { Component} from '@angular/core';

@Component({
  selector: 'app-dias',
  templateUrl: './dias.component.html',
  styleUrls: ['./dias.component.css']
})
export class DiasComponent {

   dias:string[]=["Lunes","Martes","Miercoles",
  "Jueves","Viernes","Sabado","Domingo"];

  borrar():void{

      this.dias=[];

  }
}
