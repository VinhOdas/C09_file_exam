package com.codegym.dto;

import com.codegym.model.DiemDen;
import com.codegym.model.DiemDi;
import com.codegym.model.LoaiXe;
import com.codegym.model.NhaXe;

import javax.validation.constraints.NotBlank;

public class BenXeDto {
    private Integer id;
    @NotBlank(message = "Không được để trống")
    private Integer maXe;
    @NotBlank(message = "Không được để trống")
    private String phone;
    @NotBlank(message = "Không được để trống")
    private String email;
    private Integer gioDi;
    private Integer gioDen;
    private boolean flagDelete = false;
    private DiemDen diemDen;
    private DiemDi diemDi;
    private LoaiXe loaiXe;
    private NhaXe nhaXe;

    public BenXeDto() {
    }

    public BenXeDto(Integer id, Integer maXe, String phone, String email, Integer gioDi, Integer gioDen, boolean flagDelete, DiemDen diemDen, DiemDi diemDi, LoaiXe loaiXe, NhaXe nhaXe) {
        this.id = id;
        this.maXe = maXe;
        this.phone = phone;
        this.email = email;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
        this.flagDelete = flagDelete;
        this.diemDen = diemDen;
        this.diemDi = diemDi;
        this.loaiXe = loaiXe;
        this.nhaXe = nhaXe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaXe() {
        return maXe;
    }

    public void setMaXe(Integer maXe) {
        this.maXe = maXe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGioDi() {
        return gioDi;
    }

    public void setGioDi(Integer gioDi) {
        this.gioDi = gioDi;
    }

    public Integer getGioDen() {
        return gioDen;
    }

    public void setGioDen(Integer gioDen) {
        this.gioDen = gioDen;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public DiemDen getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(DiemDen diemDen) {
        this.diemDen = diemDen;
    }

    public DiemDi getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(DiemDi diemDi) {
        this.diemDi = diemDi;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }
}
