import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejercicio1',
  templateUrl: './ejercicio1.component.html',
  styleUrls: ['./ejercicio1.component.css']
})
export class Ejercicio1Component implements OnInit {

  num1:number=0;
  num2:number=0;
  resultado:number=0;

  suma():void{
    this.resultado=this.num1+this.num2;
  }
  resta():void{
    this.resultado=this.num1-this.num2;
  }
  multiplicacion():void{
    this.resultado=this.num1*this.num2;
  }
  division():void{
    this.resultado=this.num1/this.num2;
  }


  constructor() { }

  ngOnInit(): void {
  }

}
