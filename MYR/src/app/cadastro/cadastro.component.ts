import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { regrasFormat } from '../regras';



@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  regras = new regrasFormat();

  constructor(private dataService:DataService) { }

  ngOnInit() {

  }

  onSubmit() {
    this.dataService.cadastrar(this.regras).subscribe(
      data=>console.log('sucess'+data),
      error => console.log ('error'+error)

    )
  }
}
