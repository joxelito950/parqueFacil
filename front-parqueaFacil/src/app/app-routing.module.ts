import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MapComponent } from './pages/map/map.component';
import { ParqueaderoDetailComponent } from './pages/parqueadero-detail/parqueadero-detail.component';

const routes: Routes = [
  { path: '', component: MapComponent },
  { path: 'parqueadero/:id', component: ParqueaderoDetailComponent },
  { path: '**', redirectTo: '/' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
