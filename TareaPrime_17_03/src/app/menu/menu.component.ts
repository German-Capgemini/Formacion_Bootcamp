import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styles: [
  ]
})
export class MenuComponent implements OnInit {

  items!: MenuItem[];

  ngOnInit() {
      this.items = [

            {label: 'Sobre mi',
             routerLink:'sobreMi'
            },
            {label: 'Mi experiencia',
             routerLink:'miExperiencia'
            },
            {label: 'Portfolio',
             routerLink:'portfolio'
            },
            {label: 'contacto',
             routerLink:'contacto'
            },


            

      ];
  }




}
