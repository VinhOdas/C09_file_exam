import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenXe} from "../model/ben-xe";
import {NhaXe} from "../model/nha-xe";

@Injectable({
  providedIn: 'root'
})
export class NhaXeService {
NHA_XE = 'http://localhost:8080/nhaXe'
  constructor(private httpClient: HttpClient) {

  }
  findAll():Observable<NhaXe[]> {
    return this.httpClient.get<NhaXe[]>(this.NHA_XE)

  }
}
