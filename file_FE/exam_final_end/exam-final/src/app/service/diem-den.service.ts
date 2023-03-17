import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DiemDi} from "../model/diem-di";
import {DiemDen} from "../model/diem-den";

@Injectable({
  providedIn: 'root'
})
export class DiemDenService {
  DIEM_DEN = 'http://localhost:8080/diemDen'

  constructor(private httpClient: HttpClient) { }

  findAll():Observable<DiemDen[]> {
    return this.httpClient.get<DiemDen[]>(this.DIEM_DEN)

  }
}
