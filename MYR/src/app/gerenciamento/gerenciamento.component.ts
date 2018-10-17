import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { IdadosLista } from '../dadosListar';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import { EditarComponent } from '../editar/editar.component';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';

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

  constructor(private dataservice: DataService, public dialog: MatDialog) { 
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
  
  
}


