import { Component, OnInit } from '@angular/core';
import {BenXe} from "../../model/ben-xe";
import {LoaiXe} from "../../model/loai-xe";
import {NhaXe} from "../../model/nha-xe";
import {DiemDi} from "../../model/diem-di";
import {BenXeService} from "../../service/ben-xe.service";
import {Router} from "@angular/router";
import {LoaiXeService} from "../../service/loai-xe.service";
import {NhaXeService} from "../../service/nha-xe.service";
import {DiemDiService} from "../../service/diem-di.service";
import {DiemDenService} from "../../service/diem-den.service";

@Component({
  selector: 'app-ben-xe',
  templateUrl: './ben-xe.component.html',
  styleUrls: ['./ben-xe.component.css']
})
export class BenXeComponent implements OnInit {
  benXeList: BenXe[] = [];
  loaiXeList: LoaiXe[] = [];
  nhaXeList: NhaXe[] = [];
  diemDiList: DiemDi[] = [];
  diemDenList: DiemDi[] = [];
  remove: BenXe = {};
  searchLoaiXe = '';
  searchName = '';
  searchNhaXe = '';
  searchDiemDi = '';
  searchDiemDen = '';


  constructor(private benXeService: BenXeService,
              private router: Router,
              private loaiXeService: LoaiXeService,
              private nhaXeService: NhaXeService,
              private diemDiService: DiemDiService,
              private diemDenService: DiemDenService) {

  }

  ngOnInit(): void {
    this.searchLoaiXe = '';
    this.searchName = '';
    this.searchNhaXe = '';
    this.searchDiemDi = '';
    this.searchDiemDen = '';

    this.getAllBenXe()
    this.getAllLoaiXe()
    this.getAllNhaXe()
    this.getAllDiemDi()
    this.getAllDiemDen()
  }



  getAllDiemDi(){
    this.diemDiService.findAll().subscribe(data=>{
      this.diemDiList = data
    })

  }

  getAllDiemDen(){
    this.diemDenService.findAll().subscribe(data=>{
      this.diemDenList = data
    })

  }

  getAllBenXe(){
    this.benXeService.findAll().subscribe(data=>{
      this.benXeList = data
    })

  }

  getAllLoaiXe(){
    this.loaiXeService.findAll().subscribe(data=>{
      this.loaiXeList = data
    })

  }

  getAllNhaXe(){
    this.nhaXeService.findAll().subscribe(data=>{
      this.nhaXeList = data
    })

  }


  deleteXe() {
    debugger
   let temp =  this.benXeService.delete(this.remove.id).subscribe(data=>{
      if (temp != null){
        alert('xoa thanh cong')
        this.ngOnInit()
      }else {
        alert('thu lai')
      }
    })

  }

  searchAll() {
    debugger
    this.benXeService.searchAll(this.searchName, this.searchLoaiXe,
      this.searchNhaXe,this.searchDiemDi,this.searchDiemDen)
      .subscribe(data =>{
        this.benXeList = data
      })

  }
}
