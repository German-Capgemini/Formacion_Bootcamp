import { Component, OnInit } from '@angular/core';
import { Regiones } from '../../interfaces/region.interfaces';
import { PaisService } from '../../services/pais.service';

@Component({
  selector: 'app-por-region',
  templateUrl: './por-region.component.html',
  styles: [
  ]
})
export class PorRegionComponent implements OnInit {

  termino:string="";

  exiteError:boolean=false;

  regiones: Regiones[]=[];

  constructor(private servicio:PaisService) {}

  buscar(){
    console.log(this.termino);

    this.exiteError=false;

    this.servicio.buscarRegion(this.termino).subscribe(
      resp=>{
      console.log(resp)
      this.regiones=resp;
      },(err)=>{
        console.log(err)
        this.exiteError=true;
      }
      );
  }


  ngOnInit(): void {
  }

}
