import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LoaiXe} from "../../model/loai-xe";
import {NhaXe} from "../../model/nha-xe";
import {DiemDi} from "../../model/diem-di";
import {BenXeService} from "../../service/ben-xe.service";
import {Router} from "@angular/router";
import {LoaiXeService} from "../../service/loai-xe.service";
import {NhaXeService} from "../../service/nha-xe.service";
import {DiemDiService} from "../../service/diem-di.service";
import {DiemDenService} from "../../service/diem-den.service";
import {BenXe} from "../../model/ben-xe";

@Component({
  selector: 'app-them-ben-xe',
  templateUrl: './them-ben-xe.component.html',
  styleUrls: ['./them-ben-xe.component.css']
})
export class ThemBenXeComponent implements OnInit {
  addFormReactive: FormGroup;
  benXeList: BenXe[] = [];
  loaiXeList: LoaiXe[] = [];
  nhaXeList: NhaXe[] = [];
  diemDiList: DiemDi[] = [];
  diemDenList: DiemDi[] = [];
  constructor(private benXeService: BenXeService,
              private router: Router,
              private loaiXeService: LoaiXeService,
              private nhaXeService: NhaXeService,
              private diemDiService: DiemDiService,
              private diemDenService: DiemDenService) {
    this.addFormReactive = new FormGroup({
      id: new FormControl(),
      maXe:new FormControl(),
      loaiXe: new FormControl('', [Validators.required]),
      nhaXe: new FormControl('', [Validators.required]),
      diemDi: new FormControl('', [Validators.required]),
      diemDen: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required,
        Validators.minLength(4),
        Validators.maxLength(9)]),
      email: new FormControl('', [Validators.required,Validators.email]),
      gioDi: new FormControl('', [Validators.required]),
      gioDen: new FormControl('', [Validators.required]),
    })

  }

  ngOnInit(): void {
    this.getAllNhaXe()
    this.getAllLoaiXe()
    this.getAllDiemDi()
    this.getAllDiemDen()
    this.benXeService.getList().subscribe(next =>{
      this.benXeList = next;
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



  submitAddBenXe() {
     let temp = this.benXeService.saveAdd(this.addFormReactive.value).subscribe(data =>{
       if (temp != null){
         alert('Thêm mới thành công ')
         this.router.navigateByUrl('benXe')
          this.addFormReactive.reset();
       }
       else {
         alert('Chỉnh  sửa thất bai');
       }
     })
  }

  checkMaXe(ma: number) {
    for (let i = 0; i < this.benXeList.length; i++) {
      if (this.benXeList[i].maXe == ma) {
        this.addFormReactive.controls.maXe.setErrors({'invalid': true})
      }
    }
  }

}
