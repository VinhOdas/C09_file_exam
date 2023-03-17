import {Component, OnInit} from '@angular/core';
import {BenXe} from "../../model/ben-xe";
import {BenXeService} from "../../service/ben-xe.service";

@Component({
  selector: 'app-ben-xe',
  templateUrl: './ben-xe.component.html',
  styleUrls: ['./ben-xe.component.css']
})
export class BenXeComponent implements OnInit {
  benXeList: any;
  remove: BenXe = {};



  constructor(private benXeService: BenXeService) {

  }

  ngOnInit(): void {

    this.getAllBenXe()
  }




  getAllBenXe(){
    this.benXeService.findAll(0).subscribe(data=>{
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

  previousPage() {
    this.benXeService.findAll(this.benXeList['number'] - 1).subscribe(next => {
      this.benXeList = next;
    })
  }

  nextPage() {
    this.benXeService.findAll(this.benXeList['number'] + 1).subscribe(next => {
      this.benXeList = next;
    })
  }
}
