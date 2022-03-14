import { Component, OnInit } from '@angular/core';
import { BrowserTransferStateModule } from '@angular/platform-browser';


@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent {

      heroes:string[]=["Spiderman","Ironman",
      "Thor","Hulk","Capitan America"];
      borrados:string[]=[];
      a:string | undefined;

      borrar():void{

        this.a=this.heroes.pop();
          this.borrados.push(this.a!);
      }




}


