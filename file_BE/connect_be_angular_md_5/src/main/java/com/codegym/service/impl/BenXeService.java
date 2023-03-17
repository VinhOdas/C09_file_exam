package com.codegym.service.impl;

import com.codegym.model.BenXe;
import com.codegym.repository.IBenXeRepository;
import com.codegym.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenXeService implements IBenXeService {
    @Autowired
    private IBenXeRepository benXeRepository;

    @Override
    public Page<BenXe> getAll(Pageable pageable) {
        return benXeRepository.getAll(pageable);
    }

    @Override
    public List<BenXe> getAllBenXe() {
        return benXeRepository.getAllBenXe();
    }

    @Override
    public BenXe findBenXeById(Integer id) {
        return benXeRepository.findBenXeById(id);
    }

    @Override
    public void deleteBenXe(Integer id) {
        benXeRepository.deleteBenXe(id);
    }

    @Override
    public void editBenXe(BenXe benXe) {
        benXeRepository.editBenXe(benXe);
    }

    @Override
    public void addBenXe(BenXe benXe) {
        benXeRepository.addBenXe(benXe);
    }
}
