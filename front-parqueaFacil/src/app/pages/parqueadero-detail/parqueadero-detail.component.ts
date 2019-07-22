import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ParqueaderosServiceService } from 'src/app/core/services/parqueaderos-service.service';
import { Parqueadero } from 'src/app/compartido/models/Parqueadero';
import { HorariosServicesService } from 'src/app/core/services/horarios-services.service';
import { Horario } from 'src/app/compartido/models/Horario';

@Component({
  selector: 'app-parqueadero-detail',
  templateUrl: './parqueadero-detail.component.html',
  styleUrls: ['./parqueadero-detail.component.css']
})
export class ParqueaderoDetailComponent implements OnInit {

  public myForm: FormGroup;
  public idParqueadero: number
  public parqueadero: Parqueadero
  public cargandoParqueadero: boolean
  public errorParqueadero: boolean
  public horarios: Horario[]
  public cargandoHorario: boolean
  public errorHorario: String

  constructor(
    private route: ActivatedRoute,
    public form: FormBuilder,
    private parqueaderoService: ParqueaderosServiceService,
    private horarioServices: HorariosServicesService
  ) { }

  ngOnInit() {
    this.getIdParam();
    this.reserveFrom();
    this.getParqueadero();
    this.getHorarios();
  }

  getIdParam(): void {
    this.idParqueadero = +this.route.snapshot.paramMap.get('id');
  }

  public reserveFrom(): void {
    this.myForm = this.form.group({
      fechaInicial: ['', [
        Validators.required,
      ]],
      fechaFin: ['', [
        Validators.required
      ]]
    });
  }

  getParqueadero(): void {
    this.cargandoParqueadero = true;
    this.errorParqueadero = false;
    this.parqueaderoService.getParqueadero(this.idParqueadero).subscribe(
      response => {
        this.parqueadero = response;
        this.cargandoParqueadero = false;
        this.errorParqueadero = false;
      },
      error => {
        this.errorParqueadero = true;
      }
    );
  }

  getHorarios(): void {
    this.errorHorario = null;
    this.cargandoHorario = true;
    this.horarioServices.getHorariosById(this.idParqueadero, "parqueadero").subscribe(
      response => {
        this.horarios = response;
        this.cargandoHorario = false;
        this.errorHorario = null;
      },
      (error) => {
        this.errorHorario = error.error.message;
        this.cargandoHorario = false;
      }
    );
  }

  onSubmit(): void {
    console.warn(this.myForm.value);
  }
}
