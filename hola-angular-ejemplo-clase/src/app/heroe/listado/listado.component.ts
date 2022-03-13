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
      borrar():void{

         var a:string| undefined;
        a=this.heroes.pop();
            this.borrados.push(a!);
      }




}


