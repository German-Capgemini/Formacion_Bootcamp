import { Component } from '@angular/core';
import { Personaje } from '../interfaces/interface';
import { DbzService } from '../services/dbz.service';




@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent   {


  constructor(private dbzServicio:DbzService){
    dbzServicio.saludar();
  }


  /*agregar(){

    if(this.nuevo.nombre.trim().length===0){

      return;

    }

    console.log(this.nuevo);

    this.personajes.push(this.nuevo);

    this.nuevo={

      nombre:'',
      poder: 0,


    }
  }*/

  agregarNuevoPersonaje(personaje:Personaje):void{
      console.log(personaje);
  }


}
