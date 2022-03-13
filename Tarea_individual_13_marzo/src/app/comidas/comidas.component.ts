import { Component } from '@angular/core';

@Component({
  selector: 'app-comidas',
  templateUrl: './comidas.component.html',
  styleUrls: ['./comidas.component.css']
})
export class ComidasComponent{

  comidas:string[]=["Pizza","Hamburguesa","Pasta","Sushi","Arroz"]


  borrar():void{
    this.comidas=[];
  }

}
