import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

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
  public cargandoParqueaderos: boolean

  constructor(
    private route: ActivatedRoute,
    private router: Router,
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
        this.cargandoParqueaderos = false;
      },
      error => {
        this.cargandoParqueaderos = false;
      }
    );
  }

  onChange(event) {
    this.router.navigate(['../parqueadero', event.id], { relativeTo: this.route });
  }

}
