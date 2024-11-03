
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bloc } from './bloc.model'; // Assurez-vous d'importer le modèle Bloc

@Injectable({
  providedIn: 'root'
})
export class BlocService {
  private apiUrl = 'http://localhost:8089/tpfoyer/bloc'; // URL de votre API

  constructor(private http: HttpClient) {}

  getBlocs(): Observable<Bloc[]> {
    return this.http.get<Bloc[]>(`${this.apiUrl}/retrieve-all-blocs`);
  }}
