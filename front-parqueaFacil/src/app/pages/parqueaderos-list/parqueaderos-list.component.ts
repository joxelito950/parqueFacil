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

  constructor(
    public listParqueaderos: ParqueaderosServiceService
  ) { }

  ngOnInit() {
    this.getList();
  }

  getList(): void {
    this.listParqueaderos.getAllParqueaderos().subscribe(
      response => {
        this.parqueaderos = response;
        this.parqueaderosCopy = response;
      },
      error => {
        console.error(error);
      }
    );
  }

}
