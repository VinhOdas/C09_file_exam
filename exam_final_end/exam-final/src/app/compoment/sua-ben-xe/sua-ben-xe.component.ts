import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {BenXe} from "../../model/ben-xe";
import {BenXeService} from "../../service/ben-xe.service";
import {LoaiXeService} from "../../service/loai-xe.service";
import {NhaXeService} from "../../service/nha-xe.service";
import {DiemDiService} from "../../service/diem-di.service";
import {DiemDenService} from "../../service/diem-den.service";
import {LoaiXe} from "../../model/loai-xe";
import {NhaXe} from "../../model/nha-xe";
import {DiemDi} from "../../model/diem-di";
import {DiemDen} from "../../model/diem-den";

@Component({
  selector: 'app-sua-ben-xe',
  templateUrl: './sua-ben-xe.component.html',
  styleUrls: ['./sua-ben-xe.component.css']
})
export class SuaBenXeComponent implements OnInit {
  editFormBenXe: FormGroup
  benXeEdit: BenXe = {}
  loaiXeList: LoaiXe[] = [];
  nhaXeList: NhaXe[] = [];
  diemDiList: DiemDi[] = [];
  diemDenList: DiemDi[] = [];
  constructor(private activeRouter: ActivatedRoute,
              private benXeService: BenXeService,
              private router: Router,
              private loaiXeService: LoaiXeService,
              private nhaXeService: NhaXeService,
              private diemDiService: DiemDiService,
              private diemDenService: DiemDenService) {
    this.editFormBenXe = new FormGroup({
      id: new FormControl(),
      maXe: new FormControl(),
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

    this.activeRouter.paramMap.subscribe(data=>{
      const id = data.get("id")
      if (id != null) {
        this.finById(parseInt(id))
      }
    })
  }

  ngOnInit(): void {
    this.getAllNhaXe()
    this.getAllLoaiXe()
    this.getAllDiemDi()
    this.getAllDiemDen()

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




  submitEditBenXe(): any {
    this.benXeEdit = this.editFormBenXe.value
    if (this.editFormBenXe){
      let temp = this.benXeService.saveEdit(this.benXeEdit.id, this.benXeEdit).subscribe(data =>{
        if (temp != null && data){
          alert(' chinh sua thanh cong ')
        }
        this.router.navigateByUrl('/benXe')
      })
    }else {
      alert(' chinh sua that bai')
    }

  }
  compareWith(o1: LoaiXe, o2: LoaiXe ): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  compareWithnhaXe(o1: NhaXe, o2: NhaXe ): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
  compareWithdiemDi(o1: DiemDi, o2: DiemDi ): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
  compareWithdiemDen(o1: DiemDen, o2: DiemDen ): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }
  private finById(id: number): void {
    this.benXeService.findById(id).subscribe(data =>{
          this.editFormBenXe.patchValue(data)

    })

  }


}
