package com.codegym.model;

import javax.persistence.*;

@Entity
public class BenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer maXe;
    private String phone;
    private String email;
    private Integer gioDi;
    private Integer gioDen;
    private boolean flagDelete;
    @ManyToOne
    @JoinColumn(name = "diem_den_id", referencedColumnName = "id")
    private DiemDen diemDen;

    @ManyToOne
    @JoinColumn(name = "diem_di_id", referencedColumnName = "id")
    private DiemDi diemDi;
    @ManyToOne
    @JoinColumn(name = "loai_xe_id", referencedColumnName = "id")
    private LoaiXe loaiXe;
    @ManyToOne
    @JoinColumn(name = "nha_xe_id", referencedColumnName = "id")
    private NhaXe nhaXe;

    public BenXe() {
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
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
