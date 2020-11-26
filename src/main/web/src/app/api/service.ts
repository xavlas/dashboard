import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
export const URL_BASE: string = '/api';
import {catchError, map, tap} from 'rxjs/operators';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Service {

  constructor(private http: HttpClient) { }

  getMeteo():Observable<string> {
    return this.http.get<string>(URL_BASE + '/meteo' ).pipe(
      tap(response => {
        console.log("response = " + response)
        return response;
      }),
      map(response => {
        console.log("response = " + response)
        return response;
      }),
      catchError(error => {
          throw (error);
        }
      ));
  }
}
