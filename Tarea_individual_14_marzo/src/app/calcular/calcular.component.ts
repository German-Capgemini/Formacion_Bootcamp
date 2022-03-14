import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-calcular',
  templateUrl: './calcular.component.html',
  styles: [
  ]
})
export class CalcularComponent  {
  @Input() parametro1:number=0;
  @Input() parametro2:number=0;
  resultado:number=0;

    sumar(){

          this.resultado=this.parametro1+this.parametro2;
          this.enviarResultado();
    }

    restar(){

      this.resultado=this.parametro1-this.parametro2;
      this.enviarResultado();
}

      multiplicar(){

        this.resultado=this.parametro1*this.parametro2;
        this.enviarResultado();
      }

      dividir(){

        this.resultado=this.parametro1/this.parametro2;
        this.enviarResultado();
      }

      limpiar(){

        this.resultado=0;
        this.parametro1=0;
        this.parametro2=0;

      }

      @Output() miEvento= new EventEmitter<number>();

      enviarResultado(){

        this.miEvento.emit(this.resultado);
      }


}
