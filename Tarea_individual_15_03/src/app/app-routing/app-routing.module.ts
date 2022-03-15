import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AComponent } from '../a/a.component';
import { BComponent } from '../b/b.component';
import { CComponent } from '../c/c.component';
import { DComponent } from '../d/d.component';
import { EComponent } from '../e/e.component';



const routes: Routes=[

  {
    path:'A',
    component: AComponent,
    pathMatch:'full',
  },
  {
    path:'B',
    component: BComponent
  },
  {
    path:'C',
    component: CComponent
  },
  {
    path:'D',
    component: DComponent
  },
  {
    path:'E',
    component: EComponent
  },
  {
    path:'**',
    redirectTo:''
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
