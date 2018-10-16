import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IdadosLista } from '../dadosListar';




@Component({
  selector: 'app-gerenciamento',
  templateUrl: './gerenciamento.component.html',
  styleUrls: ['./gerenciamento.component.css']
})
export class GerenciamentoComponent implements OnInit {

  registros = [];


  constructor(private dataservice: DataService) { }

  ngOnInit() {
    this.dataservice.listar().subscribe(dados => this.registros = dados.data);
  }
}

