import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./compoment/common/home/home.component";

import {BenXeComponent} from "./compoment/ben-xe/ben-xe.component";
import {SuaBenXeComponent} from "./compoment/sua-ben-xe/sua-ben-xe.component";
import {ThemBenXeComponent} from "./compoment/them-ben-xe/them-ben-xe.component";


const routes: Routes = [
  {
    path: "", component: HomeComponent
  },
  {
    path: "benXe", component: BenXeComponent
  },
  {
    path: "benXe/edit/:id", component: SuaBenXeComponent
  },
  {
    path: "benXe/add", component: ThemBenXeComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
