import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MenubarModule} from 'primeng/menubar';
import {AccordionModule} from 'primeng/accordion';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {BreadcrumbModule} from 'primeng/breadcrumb';
import {StepsModule} from 'primeng/steps';
import {AvatarModule} from 'primeng/avatar';
import {AvatarGroupModule} from 'primeng/avatargroup';
import {CarouselModule} from 'primeng/carousel';
import {InputTextModule} from 'primeng/inputtext';

import {InputMaskModule} from 'primeng/inputmask';
import {CardModule} from 'primeng/card';
import {ButtonModule} from 'primeng/button';

import {PanelModule} from 'primeng/panel';

import {FocusTrapModule} from 'primeng/focustrap';

import {EditorModule} from 'primeng/editor';

import {InputTextareaModule} from 'primeng/inputtextarea';
import {DividerModule} from 'primeng/divider';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MenubarModule,
    AccordionModule,
    ScrollPanelModule,
    BreadcrumbModule,
    StepsModule,
    CardModule,
    AvatarModule,
    AvatarGroupModule,
    CarouselModule,
    InputTextModule,
    InputMaskModule,
    ButtonModule,
    PanelModule,
    FocusTrapModule,
    EditorModule,
    InputTextareaModule,
    DividerModule

  ],
  exports:[
    MenubarModule,
    AccordionModule,
    ScrollPanelModule,
    BreadcrumbModule,
    StepsModule,
    CardModule,
    AvatarModule,
    AvatarGroupModule,
    CarouselModule,
    InputTextModule,
    InputMaskModule,
    ButtonModule,
    PanelModule,
    FocusTrapModule,
    EditorModule,
    InputTextareaModule,
    DividerModule
  ]
})
export class ModulosPrimeModule { }
