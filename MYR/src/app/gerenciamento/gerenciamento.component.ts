import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { IdadosLista } from '../dadosListar';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';

@Component({
  selector: 'app-gerenciamento',
  templateUrl: './gerenciamento.component.html',
  styleUrls: ['./gerenciamento.component.css']
})
export class GerenciamentoComponent implements OnInit {

  dataSource = new RegistrosDataSource(this.dataservice);
  displayedColumns = ['Id', 'nome', 'descricao', 'nomeParEntrada', 'tipoParEntrada', 'mandatorio', 'nomeParSaida', 'tipoParSaida'];
  

  constructor(private dataservice: DataService) { }

  ngOnInit() {
    
  }
  
}
export class RegistrosDataSource extends DataSource <any>{
  constructor(private dataService:DataService){
    super();
  }

  connect(): Observable<IdadosLista[]>{
    return this.dataService.listar(); 
  }

  disconnect(){}
}
