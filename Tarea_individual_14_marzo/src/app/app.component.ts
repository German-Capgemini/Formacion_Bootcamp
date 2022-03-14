import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  parm1:number=0;
  parm2:number=0;
  result:any;

cogerResultado(e: any){
  this.result=e;
}
}
