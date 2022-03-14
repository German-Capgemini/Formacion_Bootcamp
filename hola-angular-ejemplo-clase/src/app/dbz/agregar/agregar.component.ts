import { Component, Input, Output,EventEmitter} from '@angular/core';

import { Personaje } from '../interfaces/interface';
import { DbzService } from '../services/dbz.service';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent  {

 @Input() personajes:Personaje[]=[];

 @Input() nuevo:Personaje={

    nombre:"",
    poder:0
 }

 @Output() onNuevoPersonaje: EventEmitter<Personaje> = new EventEmitter()

constructor(private servicio:DbzService){


}



 agregar():void{

  if(this.nuevo.nombre.trim().length===0){

    return;

  }
/*
  console.log(this.nuevo);

  this.personajes.push(this.nuevo);
*/
  this.onNuevoPersonaje.emit(this.nuevo);

  this.servicio.agregarPersonaje(this.nuevo);

  this.nuevo={

    nombre:'',
    poder: 0,


  }
}




}
