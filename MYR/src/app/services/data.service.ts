import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IdadosLista } from '../dadosListar';
import { Observable } from 'rxjs';
import { regrasFormat } from '../regras';


@Injectable({ providedIn: 'root' })

export class DataService {

  private apiURL = 'http://localhost:3000/data';

  constructor(private http: HttpClient) { }


  listar(): Observable<IdadosLista[]> {
    return this.http.get<IdadosLista[]>(this.apiURL)
  }

  cadastrar(regras: regrasFormat) {
    return this.http.post<any>(this.apiURL, regras);
  }


}
