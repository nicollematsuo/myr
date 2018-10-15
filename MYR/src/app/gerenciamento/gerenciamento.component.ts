import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-gerenciamento',
  templateUrl: './gerenciamento.component.html',
  styleUrls: ['./gerenciamento.component.css']
})
export class GerenciamentoComponent implements OnInit {

  registros: Array <any>;

  constructor(private service: DataService) { }

  ngOnInit() {
  this.listar();
  }

  listar(){
    this.service.listar().subscribe(dados=> this.registros = dados);
  }

}
