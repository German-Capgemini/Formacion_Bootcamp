import { Component, Input} from '@angular/core';
import { DbzService } from '../services/dbz.service';

@Component({
  selector: 'app-personajes',
  templateUrl: './personajes.component.html',
  styleUrls: ['./personajes.component.css']
})
export class PersonajesComponent  {

//@Input() person:any[]=[];

constructor(private DbzServicio:DbzService){
}

get person(){
  return this.DbzServicio.personajes;
}




}
