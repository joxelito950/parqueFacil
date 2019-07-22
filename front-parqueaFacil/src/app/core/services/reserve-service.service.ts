import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReserveServiceService {

  constructor(
    private http: HttpClient
  ) { }

  saveReserve(reserve: any): Observable<number> {
    return this.http.post<any>(`http://localhost:8080/reserve/save`, reserve);
  }
}
