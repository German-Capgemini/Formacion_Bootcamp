import { Component } from '@angular/core';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',

})

export class HeroesComponent {

  nombre:string="Ironman";
  edad:number=45;

  get nombreCapitalizado():string{
      return this.nombre.toUpperCase();
  }

  obtenerNombre():string{
      return `${this.nombre} - ${this.edad}`;

  }

  cambiarEdad():void{

    this.edad=30;

}

cambiarNombre():void{
  this.nombre="Spiderman";

}

}
