import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { Ejercicio1Component } from '../ejercicio1/ejercicio1.component';
import { Ejercicio2Component } from '../ejercicio2/ejercicio2.component';
import { Ejercicio3Component } from '../ejercicio3/ejercicio3.component';
import { Ejercicio4Component } from '../ejercicio4/ejercicio4.component';
import { Ejercicio5Component } from '../ejercicio5/ejercicio5.component';



const routes: Routes=[

  {
    path:'',
    component: Ejercicio1Component,

  },
  {
    path:'1',
    component: Ejercicio1Component,

  },
  {
    path:'2',
    component: Ejercicio2Component,
  },
  {
    path:'3',
    component: Ejercicio3Component,
  },
  {
    path:'4',
    component: Ejercicio4Component,
  },
  {
    path:'5',
    component: Ejercicio5Component,
  },
  {
    path:'**',
    redirectTo:'1'
  }
  ]

  @NgModule({
    declarations: [],
    imports: [
      CommonModule,
      RouterModule.forRoot( routes )
    ],
  exports:[
    RouterModule
  ]

  })
  export class AppRoutingModule { }
