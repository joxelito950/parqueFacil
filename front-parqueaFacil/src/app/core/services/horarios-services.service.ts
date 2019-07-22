import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Horario } from 'src/app/compartido/models/Horario';

@Injectable({
  providedIn: 'root'
})
export class HorariosServicesService {

  constructor(
    private http: HttpClient
  ) { }

  getHorariosById(id: number, tipo: String): Observable<Horario[]> {
    return this.http.get<Horario[]>(`http://localhost:8080/horarios/${tipo}/${id}`);
  }
}
