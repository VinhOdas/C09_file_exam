package com.codegym.repository;

import com.codegym.model.BenXe;
import com.codegym.model.LoaiXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILoaiXeRepository extends JpaRepository<LoaiXe, Integer> {
    @Query(value = "select * from loai_xe ",nativeQuery = true)
    List<LoaiXe> getAll();
}
