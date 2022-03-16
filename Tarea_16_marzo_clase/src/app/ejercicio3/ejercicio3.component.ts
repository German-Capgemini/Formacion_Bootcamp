import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio3',
  templateUrl: './ejercicio3.component.html',
  styleUrls: ['./ejercicio3.component.css']
})
export class Ejercicio3Component implements OnInit {

  base:number=0;
  altura:number=0;
  resultado:number=0;


  calcular():void{


    this.resultado=(this.base+this.altura)*2;
  }


  constructor() { }

  ngOnInit(): void {
  }

}
