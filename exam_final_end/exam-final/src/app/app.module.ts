import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './compoment/common/header/header.component';
import { FooterComponent } from './compoment/common/footer/footer.component';
import { HomeComponent } from './compoment/common/home/home.component';
import { NavigationComponent } from './compoment/common/navigation/navigation.component';

import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import { BenXeComponent } from './compoment/ben-xe/ben-xe.component';
import { ThemBenXeComponent } from './compoment/them-ben-xe/them-ben-xe.component';
import { SuaBenXeComponent } from './compoment/sua-ben-xe/sua-ben-xe.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavigationComponent,
    BenXeComponent,
    ThemBenXeComponent,
    SuaBenXeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
