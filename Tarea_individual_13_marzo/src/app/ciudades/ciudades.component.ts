import { Component} from '@angular/core';

@Component({
  selector: 'app-ciudades',
  templateUrl: './ciudades.component.html',
  styleUrls: ['./ciudades.component.css']
})
export class CiudadesComponent  {

    ciudades:string[]=[];

    borradas:string[]=[];

    mostrarCiudades():void{

      this.ciudades=["Sevilla","Madrid","Barcelona","Valencia","Bilbao"];

    }

    borrarCiudades():void{

        this.borradas.push(this.ciudades.pop()!);

    }



}
