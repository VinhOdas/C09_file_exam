package com.codegym.service;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBenXeService {

    Page<BenXe> getAll(Pageable pageable);

    List<BenXe> getAllBenXe();

    BenXe findBenXeById(Integer id);

    void deleteBenXe(Integer id);

    void editBenXe(BenXe benXe);

    void addBenXe(BenXe benXe);
}
