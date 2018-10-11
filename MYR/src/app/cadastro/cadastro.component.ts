import { Component, OnInit } from '@angular/core';

import { Regras } from '../Regras';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  regras = new Regras ();

  constructor() { }

  ngOnInit() {
  }

}
