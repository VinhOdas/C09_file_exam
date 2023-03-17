import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenXe} from "../model/ben-xe";
import {LoaiXe} from "../model/loai-xe";

@Injectable({
  providedIn: 'root'
})
export class LoaiXeService {
LOAIXE = 'http://localhost:8080/loaiXe'
  constructor(private httpClient: HttpClient) { }

  findAll():Observable<LoaiXe[]> {
    return this.httpClient.get<LoaiXe[]>(this.LOAIXE)

  }
}
