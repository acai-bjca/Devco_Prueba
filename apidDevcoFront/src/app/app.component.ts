import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from './http-services/apiservice.service';
import { Asignacion } from './utils/models/asignacion.model';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastContainerDirective, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'apidDevcoFront';
  dispositivoId: string = '0';
  empleadoId: number = 0;

  public formDatos !: FormGroup;
  constructor(private apiService: ApiserviceService, private formBuilder: FormBuilder,
    private toastrService: ToastrService) { }

  public ngOnInit() {
    this.buildForm();
  }

  public buildForm() {
    this.formDatos = this.formBuilder.group({
      dispositivoC: ['', [Validators.required]],
      empleadoC: ['', [Validators.required]],
    });
  }

  public addAsignacion(): void {
    console.log("addAsignacion");
    console.log(this.formDatos.value.dispositivo);
    this.formDatos.markAllAsTouched();
    if (this.formDatos.valid) {
      let asignacion: Asignacion = new Asignacion();
      asignacion.dispositivoId = this.formDatos.value.dispositivoC;
      asignacion.empleadoId = this.formDatos.value.empleadoC;
      this.apiService.asignarDispositivoPost(asignacion)
        .subscribe({
          next: (data) => {
            this.toastrService.info(data.notification);
            console.log(data);
          },
          error: (err) => {
            this.toastrService.error(err.error.notification);
            console.log("err");
          },
          complete: () => {

          }
        });
    } else {
      this.toastrService.error("Todos los campos son requeridos. Solo se aceptan números");
    }
  }

}

