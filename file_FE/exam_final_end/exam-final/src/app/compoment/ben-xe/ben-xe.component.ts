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

  remove: BenXe = {};



  constructor(private benXeService: BenXeService) {

  }

  ngOnInit(): void {

    this.getAllBenXe()
  }




  getAllBenXe(){
    this.benXeService.findAll().subscribe(data=>{
      this.benXeList = data
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
}
