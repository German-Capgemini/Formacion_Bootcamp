import { Component, OnInit } from '@angular/core';
import { Capitales } from '../../interfaces/capital.interfaces';
import { Countries } from '../../interfaces/pais.interfaces';
import { PaisService } from '../../services/pais.service';

@Component({
  selector: 'app-por-capital',
  templateUrl: './por-capital.component.html',
  styleUrls: ['./por-capital.component.css']
})
export class PorCapitalComponent implements OnInit {

termino:string="";

exiteError:boolean=false;

 capitales: Capitales []=[];

 constructor(private servicio:PaisService) { }

 buscar(){
  console.log(this.termino);

  this.exiteError=false;

  this.servicio.buscarCapital(this.termino).subscribe(
    resp=>{
    console.log(resp)
    this.capitales=resp;
    },(err)=>{
      console.log(err)
      this.exiteError=true;
    }
    );
}


ngOnInit(): void {
 }

}
