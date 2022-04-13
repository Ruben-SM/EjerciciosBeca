import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class UsuarioService{


  /**
   * Este constructor recibirá inyectado un objeto de tipo _HttpClient, que será
   * en encargado de hacer las peticiones HTTP a nuestro servicio REST
   * @param _httpClient 
   */

    readonly endPoint = 'http://localhost:8080/Ejercicio21/usuarios/login'

  constructor(private _httpClient : HttpClient) { }

  public login(nombre: string, password: string): Observable<any>{
    return this._httpClient.get<any>(`${this.endPoint}?nombre=${nombre}&password=${password}`).pipe(catchError(this.manejarError))
  }

  private manejarError(e: HttpErrorResponse){
    let mensajeError = ''
    if (e.error instanceof ErrorEvent) {
      mensajeError = 'A ocurrido un error:' + e.error
    } else {
      mensajeError = `El servicio Rest retorno: Status: ${e.status}, ` +
            `Body: ${e.error}`
    }
    console.error(mensajeError)
    return throwError(() => new Error(mensajeError));
  }

}