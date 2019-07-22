import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ParqueaderosServiceService } from 'src/app/core/services/parqueaderos-service.service';
import { Parqueadero } from 'src/app/compartido/models/Parqueadero';

@Component({
  selector: 'app-parqueadero-detail',
  templateUrl: './parqueadero-detail.component.html',
  styleUrls: ['./parqueadero-detail.component.css']
})
export class ParqueaderoDetailComponent implements OnInit {

  public parqueadero: Parqueadero
  public cagandoParqueadero: boolean
  public errorParqueadero: boolean

  constructor(
    private route: ActivatedRoute,
    private parqueaderoService: ParqueaderosServiceService
  ) { }

  ngOnInit() {
    this.getParqueadero();
  }

  getParqueadero(): void {
    this.cagandoParqueadero = true;
    this.errorParqueadero = false;
    const id = +this.route.snapshot.paramMap.get('id');
    this.parqueaderoService.getParqueadero(id).subscribe(
      response => {
        console.log(response);
        this.parqueadero = response;
        this.cagandoParqueadero = false;
        this.errorParqueadero = false;
      },
      error => {
        console.error(error);
        this.errorParqueadero = true;
      }
    );
  }
}
