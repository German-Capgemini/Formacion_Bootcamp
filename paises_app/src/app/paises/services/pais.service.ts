import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Capitales } from '../interfaces/capital.interfaces';
import { Countries } from '../interfaces/pais.interfaces';
import { Regiones } from '../interfaces/region.interfaces';

@Injectable({
  providedIn: 'root'
})

export class PaisService {

  //url base

  private apiUrl:string='https://restcountries.com/v3.1';

  constructor(private http:HttpClient) {}

    buscarPais(termino:string):Observable<Countries[]>{
      const url= `${this.apiUrl}/name/${ termino }`;
      return this.http.get<Countries[]>(url);
    }


    buscarCapital(termino:string):Observable<Capitales[]>{
      const url= `${this.apiUrl}/capital/${ termino }`;
      return this.http.get<Capitales[]>(url);
     }

     buscarRegion(termino:string):Observable<Regiones[]>{
      const url= `${this.apiUrl}/region/${ termino }`;
      return this.http.get<Regiones[]>(url);
     }





}
