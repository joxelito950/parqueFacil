import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapComponent } from './map/map.component';
import { ParqueaderosListComponent } from './parqueaderos-list/parqueaderos-list.component';

@NgModule({
  declarations: [MapComponent, ParqueaderosListComponent],
  imports: [
    CommonModule
  ],
  exports: [
    MapComponent,
    ParqueaderosListComponent
  ]
})
export class PagesModule { }
