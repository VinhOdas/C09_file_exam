package com.codegym.service.impl;

import com.codegym.model.NhaXe;
import com.codegym.repository.INhaXeRepository;
import com.codegym.service.INhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXeService implements INhaXeService {
    @Autowired
    private INhaXeRepository nhaXeRepository;

    @Override
    public List<NhaXe> getAll() {
        return nhaXeRepository.getAll();

    }
}
