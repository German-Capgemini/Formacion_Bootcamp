import { Component } from '@angular/core';

@Component({
   selector: 'app-acumulador',
   templateUrl: './acumulador.component.html',

})

export class acumuladorComponent{
  titulo:string = "Contador";
  numero:number=10;


  suma():void {
    this.numero+= 1;

}

resta():void {
  this.numero-= 1;

}

base:number=2;

 acumulador(valor:number):void{
    this.numero=this.numero+this.base;

 }


}
