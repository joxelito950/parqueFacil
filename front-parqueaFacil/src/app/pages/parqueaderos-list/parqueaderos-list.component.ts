import { Component, OnInit } from '@angular/core';

import { ParqueaderosServiceService } from '../../core/services/parqueaderos-service.service';
import { Parqueadero } from 'src/app/compartido/models/Parqueadero';

@Component({
  selector: 'app-parqueaderos-list',
  templateUrl: './parqueaderos-list.component.html',
  styleUrls: ['./parqueaderos-list.component.css'],
  providers: [ParqueaderosServiceService]
})
export class ParqueaderosListComponent implements OnInit {
  public parqueaderos: Parqueadero[]
  public parqueaderosCopy: Parqueadero[]
  public cargandoParqueaderos: boolean

  constructor(
    public listParqueaderosService: ParqueaderosServiceService
  ) { }

  ngOnInit() {
    this.getList();
  }

  getList(): void {
    this.cargandoParqueaderos = true;
    this.listParqueaderosService.getAllParqueaderos().subscribe(
      response => {
        this.parqueaderos = response;
        this.parqueaderosCopy = response;
        this.cargandoParqueaderos = false;
      },
      error => {
        console.error(error);
        this.cargandoParqueaderos = false;
      }
    );
  }

}
