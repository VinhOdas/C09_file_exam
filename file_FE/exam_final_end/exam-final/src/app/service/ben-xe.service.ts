import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenXe} from "../model/ben-xe";

@Injectable({
  providedIn: 'root'
})
export class BenXeService {
  BEN_XE = 'http://localhost:8080/benXe'

  constructor(private httpClient: HttpClient) {
  }

  getList(): Observable<any> {
    return this.httpClient.get<any>(this.BEN_XE + '/getList')
  }

  findAll(page: number): Observable<any> {
    return this.httpClient.get<any>(this.BEN_XE + '?page=' + page)

  }

  delete(id: number | undefined) {
    debugger
    return this.httpClient.delete(this.BEN_XE + '/delete/' + id)
  }

  // findById(id: number | undefined, benXeEdit: BenXe): Observable<any> {
  //   return this.httpClient.get<any>(this.BEN_XE, id)
  //
  // }

  saveEdit(id: number | undefined, benXeEdit: BenXe): Observable<any> {
    return this.httpClient.put<any>(this.BEN_XE + '/edit/' + benXeEdit.id, benXeEdit)

  }

  findById(id: number | undefined): Observable<any> {
    return this.httpClient.get<any>(this.BEN_XE + '/' + id);

  }

  saveAdd(benXe: BenXe): Observable<BenXe[]> {
    return this.httpClient.post<BenXe[]>(this.BEN_XE + '/create', benXe);

  }

  searchAll(maXe: string, loaiXe: string, nhaXe: string, diemDi: string, diemDen: string): Observable<any> {
    debugger
    return this.httpClient.get<any>
    (this.BEN_XE + '?maXe_like=' + maXe + '&loaiXe.name=' + loaiXe + '&diemDi.name=' + diemDi
      + '&diemDen.name=' + diemDen)

  }
}
