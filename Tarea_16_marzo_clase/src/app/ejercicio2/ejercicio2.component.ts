import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.component.html',
  styleUrls: ['./ejercicio2.component.css']
})
export class Ejercicio2Component implements OnInit {

  base:number=0;
  altura:number=0;
  resultado:number=0;


  calcular():void{


    this.resultado=(this.base*this.altura)/2;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
