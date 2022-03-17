import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './vistas/contacto/contacto.component';
import { MiExperienciaComponent } from './vistas/mi-experiencia/mi-experiencia.component';
import { PortfolioComponent } from './vistas/portfolio/portfolio.component';
import { SobreMiComponent } from './vistas/sobre-mi/sobre-mi.component';

const routes: Routes = [

  {
    path: 'sobreMi',
    component: SobreMiComponent,
    pathMatch:'full'
  },
  {
    path: 'miExperiencia',
    component: MiExperienciaComponent,
    pathMatch:'full'
  },
  {
    path: 'portfolio',
    component: PortfolioComponent,
    pathMatch:'full'
  },
  {
    path: 'contacto',
    component: ContactoComponent,
    pathMatch:'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
