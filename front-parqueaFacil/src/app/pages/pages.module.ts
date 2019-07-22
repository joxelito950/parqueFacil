import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapComponent } from './map/map.component';
import { ParqueaderosListComponent } from './parqueaderos-list/parqueaderos-list.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [MapComponent, ParqueaderosListComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgSelectModule
  ],
  exports: [
    FormsModule,
    NgSelectModule,
    MapComponent,
    ParqueaderosListComponent
  ]
})
export class PagesModule { }
