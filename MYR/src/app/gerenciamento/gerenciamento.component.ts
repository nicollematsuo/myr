import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { IdadosLista } from '../dadosListar';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { EditarComponent } from '../editar/editar.component';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-gerenciamento',
  templateUrl: './gerenciamento.component.html',
  styleUrls: ['./gerenciamento.component.css']
})
export class GerenciamentoComponent implements OnInit {

  Registros = null;
  displayedColumns = ['select', 'id', 'nome', 'descricao', 'nomeParEntrada', 'tipoParEntrada', 'mandatorio', 'nomeParSaida', 'tipoParSaida'];
  selection = new SelectionModel<IdadosLista>(true, []);
  dataSource = new MatTableDataSource<IdadosLista>(this.Registros);
  vet : number[] = new Array();

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
  }

  constructor(private dataservice: DataService, public dialog: MatDialog, public snackBar: MatSnackBar) { 
    dataservice.listar().subscribe(
      data=>{
        this.Registros = data;
        this.dataSource.data= this.Registros;
      }
    );
  }
  
  openDialog(): void {
    const dialogRef = this.dialog.open(EditarComponent, {
      
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      
    });
  }

  ngOnInit() {
    
  }

  verificaID(id : number) : void{
    if(!this.vet.includes(id)){
      this.vet.push(id);
    }
    else{
      this.vet.splice(this.vet.indexOf(id,0),1);
    }
  }
  
 delete(){
   var i : number;
   var sucesso : boolean = true;
   
    if (confirm ("deseja deletar?")){
    for(i=0;i<this.vet.length;i++){
      this.dataservice.deletar(this.vet[i]).subscribe(
        error => sucesso = false //console.log('error' + error)
      );
   }
   if(sucesso){
     this.snackBar.open("Deletado com sucesso!",);
   }
   else{
     this.snackBar.open("Alguma coisa errada não está certa.")
   }
   setTimeout(() => {window.location.reload()},3000);
  }
 }
  
  
}


