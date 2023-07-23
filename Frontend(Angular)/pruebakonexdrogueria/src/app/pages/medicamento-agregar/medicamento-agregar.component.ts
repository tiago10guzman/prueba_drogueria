import { Component, OnInit } from '@angular/core';
import { MedicamentoService } from 'src/app/services/medicamento.service';
import { MessageService } from 'primeng/api';
import {
  DialogService,
  DynamicDialogRef,
  DynamicDialogConfig,
} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-medicamento-agregar',
  templateUrl: './medicamento-agregar.component.html',
  styleUrls: ['./medicamento-agregar.component.css'],
})
export class MedicamentoAgregarComponent implements OnInit {
  constructor(
    private medicantoService: MedicamentoService,
    public dialogRef: DynamicDialogRef,
    public dialogConfig: DynamicDialogConfig,
    private messageService: MessageService

  ) {}
  isDisabled=false;
  texto_header: String = '';
  text_button:String='Registrar';
  nombre: string = '';
  laboratorio: string = '';
  fechaFabricacion: Date = new Date();
  fechaVencimiento: Date = new Date();
  cantidadStock: number = 0;
  valorUnitario: number = 0;


  async submitForm() {
    const medicamento = {
      nombre: this.nombre,
      laboratorio: this.laboratorio,
      fechaFabricacion: this.fechaFabricacion.toISOString(),
      fechaVencimiento: this.fechaVencimiento.toISOString(),
      cantidadStock: this.cantidadStock,
      valorUnitario: this.valorUnitario,
      estado:1
    };

    if(this.texto_header==='Modificar Medicamento'){
      await this.medicantoService.update(medicamento).toPromise().then();
      this.dialogRef.close()
      this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Modificado Correctamente' });
      await this.esperarDosSegundos();
      window.location.reload();
      return
    }


    await this.medicantoService.create(medicamento).toPromise().then();

    this.dialogRef.close()
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Agregado Correctamente' });
    await this.esperarDosSegundos();
    window.location.reload();
    
  }

  esperarDosSegundos(): Promise<void> {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve();
      }, 1500);
    });
  }

  ngOnInit(): void {
      this.chargeData()
  }

  chargeData(){
    this.texto_header= this.dialogConfig.data.texto_header;
    this.nombre= this.dialogConfig.data.m.nombre;
    this.laboratorio= this.dialogConfig.data.m.laboratorio;
    this.fechaFabricacion= new Date(this.dialogConfig.data.m.fechaFabricacion);
    this.fechaVencimiento= new Date(this.dialogConfig.data.m.fechaVencimiento);
    this.cantidadStock= this.dialogConfig.data.m.cantidadStock;
    this.valorUnitario= this.dialogConfig.data.m.valorUnitario;

    if(this.texto_header==='Modificar Medicamento'){
      this.isDisabled=true;
      this.text_button='Modificar'
    }
    
    //window.localocation.href=routes[0];
    
  }




}
