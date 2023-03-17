package com.codegym.repository;

import com.codegym.model.LoaiXe;
import com.codegym.model.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INhaXeRepository extends JpaRepository<NhaXe, Integer> {
    @Query(value = "select * from nha_xe ",nativeQuery = true)
    List<NhaXe> getAll();
}
