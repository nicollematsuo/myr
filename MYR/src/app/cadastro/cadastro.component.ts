import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { regrasFormat } from '../regras';
import {MatSnackBar} from '@angular/material';



@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  regras = new regrasFormat();

  constructor(private dataService: DataService, public snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  onSubmit() {
    this.dataService.cadastrar(this.regras).subscribe(
      data => this.snackBar.open('Item edited successfully', 'ok', {
        duration: 1000,
        panelClass: ['color-snackbar']
   }),
      error => console.log('error' + error)

    )
  }
}


