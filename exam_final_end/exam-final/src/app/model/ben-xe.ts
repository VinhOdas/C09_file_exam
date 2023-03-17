import {NhaXe} from "./nha-xe";
import {LoaiXe} from "./loai-xe";
import {DiemDi} from "./diem-di";
import {DiemDen} from "./diem-den";

export interface BenXe {
  id?: number,
  maXe?: number
  loaiXe?: LoaiXe,
  nhaXe?: NhaXe,
  diemDi?: DiemDi,
  diemDen?: DiemDen
  phone?: string,
  email?: string,
  gioDi?: number,
  gioDen?: number



}
