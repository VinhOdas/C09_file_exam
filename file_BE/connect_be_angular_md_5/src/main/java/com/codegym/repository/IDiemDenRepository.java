package com.codegym.repository;

import com.codegym.model.DiemDen;
import com.codegym.model.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDiemDenRepository extends JpaRepository<DiemDen, Integer> {
    @Query(value = "select * from diem_den ",nativeQuery = true)
    List<DiemDen> getAll();
}
