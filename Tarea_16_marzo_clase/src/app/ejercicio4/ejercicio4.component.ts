import { Component, OnInit } from '@angular/core';
import { Empleado } from '../Interfaces/empleado.interfaces';

@Component({
  selector: 'app-ejercicio4',
  templateUrl: './ejercicio4.component.html',
  styleUrls: ['./ejercicio4.component.css']
})
export class Ejercicio4Component implements OnInit {


 contador: number[]=[0,0,0,0,0];

 nombres: string[]=["","","","",""];

 salarios: number[]=[0,0,0,0,0];




 salarioMayor:number=0;

 trabajadorMayor:string="";

 indice:number=0;

 obtieneMayor(){

  this.salarioMayor=Math.max.apply(null, this.salarios);
  console.log(this.salarioMayor);
  console.log(this.salarios);

  for(let i=0;i<this.salarios.length;i++){

    if(this.salarios[i]==this.salarioMayor){
        this.indice=i;
    }
  }
  this.trabajadorMayor=this.nombres[this.indice];


 }



  constructor() { }

  ngOnInit(): void {
  }

}
