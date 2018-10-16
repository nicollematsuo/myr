import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { IdadosLista } from '../dadosListar';
import { DataService } from '../services/data.service';


@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  regras: any;

  constructor(private service: DataService) { }
  ngOnInit() {
    this.regras = {};
  }
  cadastrar(cadastroForm: FormGroup) {
    this.service.cadastrar(this.regras).subscribe(resposta =>{

      cadastroForm.reset();
    });
  }

}
