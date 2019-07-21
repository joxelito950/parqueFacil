import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Parqueadero } from 'src/app/compartido/models/Parqueadero';

@Injectable({
  providedIn: 'root'
})
export class ParqueaderosServiceService {

  constructor(
    public http: HttpClient
  ) { }

  getAllParqueaderos(): Observable<HttpResponse<Parqueadero[]>> {
    return this.http.get<any>('http://localhost:8080/parqueaderos/all');
  }
}
