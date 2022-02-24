import { Injectable } from '@angular/core';
import { ENDPOINTS } from 'src/app/utils/endpoints/endpoints';
import { HttpClient } from '@angular/common/http';
import { Asignacion } from '../utils/models/asignacion.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {
  private URL = ENDPOINTS.urlBase;
  private URL_asignaciones = ENDPOINTS.urlAsignaciones;

  constructor(private http: HttpClient) { }

  public asignarDispositivoPost(asignacion : Asignacion) : Observable<any>{
    //return this.http.post<any>(`${this.api}/ValidacionCargaMasiva?user=${usuario}&valFront=${validacionFront}&nombreArchivo=${nombreArchivo}`, producto); 
    return this.http.post<any>(`${this.URL + this.URL_asignaciones}`, asignacion); 
  }
}
