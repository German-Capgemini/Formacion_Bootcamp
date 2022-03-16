import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dorsalNombresJugadores'
})
export class DorsalNombresJugadoresPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (args != null) {
      if (args=='Real Madrid')
        switch (value) {
          case 1: return 'Courtois';
          case 2: return 'Carvajal';
          case 3: return 'Militao';
          case 4: return 'Alaba';
          case 5: return 'Vallejo';
          case 6: return 'Nacho';
          case 7: return 'Hazard';
        }
        if (args=='Barcelona')
        switch (value) {
          case 1: return 'Ter Stegen';
          case 2: return 'Dest';
          case 3: return 'Pique';
          case 4: return 'Araujo';
          case 5: return 'Busquets';
          case 6: return 'Puig';
          case 7: return 'Dembele';
        }
    }

    return null;
  }


}
