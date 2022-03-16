import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio5',
  templateUrl: './ejercicio5.component.html',
  styleUrls: ['./ejercicio5.component.css']
})
export class Ejercicio5Component implements OnInit {

  monto:number=0;

  porcentajes:number[]=[0.37,0.42,0.21]

  importes:number[]=[0,0,0];

  constructor() { }

  ngOnInit(): void {
  }

  calculaImportes():void{

    this.importes[0]=this.monto*this.porcentajes[0];
    this.importes[1]=this.monto*this.porcentajes[1];
    this.importes[2]=this.monto*this.porcentajes[2];



  }

}
