import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenXe} from "../model/ben-xe";
import {DiemDi} from "../model/diem-di";

@Injectable({
  providedIn: 'root'
})
export class DiemDiService {
  DIEM_DI = 'http://localhost:3000/diemDi'
  constructor(private httpClient: HttpClient) { }

  findAll():Observable<DiemDi[]> {
    return this.httpClient.get<DiemDi[]>(this.DIEM_DI)

  }
}
