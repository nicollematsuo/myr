import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  apiURL ='';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(`${this.apiURL}`);
  }

  cadastrar(regras: any){
    return this.http.post(this.apiURL, regras);

  }


}
