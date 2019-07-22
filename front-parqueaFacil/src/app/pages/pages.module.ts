import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapComponent } from './map/map.component';
import { ParqueaderosListComponent } from './parqueaderos-list/parqueaderos-list.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ParqueaderoDetailComponent } from './parqueadero-detail/parqueadero-detail.component';

@NgModule({
  declarations: [MapComponent, ParqueaderosListComponent, ParqueaderoDetailComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgSelectModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    NgSelectModule,
    MapComponent,
    ParqueaderosListComponent
  ]
})
export class PagesModule { }
