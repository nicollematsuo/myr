import { Component, OnInit, Input} from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {regrasFormat } from '../Regras';


@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  @Input() nome:string;
  regras = new regrasFormat();
 
  constructor(public thisDialogRef: MatDialogRef<EditarComponent>) { }

  ngOnInit() {
    
  }

  salvar(){
    this.thisDialogRef.close("It Was Saved")

}
}