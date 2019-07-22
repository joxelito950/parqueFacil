import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Parqueadero } from 'src/app/compartido/models/Parqueadero';

@Injectable({
  providedIn: 'root'
})
export class ParqueaderosServiceService {

  constructor(
    private http: HttpClient
  ) { }

  getAllParqueaderos(): Observable<Parqueadero[]> {
    return this.http.get<Parqueadero[]>('http://localhost:8080/parqueaderos/all');
  }

  getParqueadero(id: number): Observable<Parqueadero> {
    return this.http.get<Parqueadero>(`http://localhost:8080/parqueaderos/${id}`);
  }
}
