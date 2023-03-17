package com.codegym.service.impl;

import com.codegym.model.DiemDen;
import com.codegym.repository.IDiemDenRepository;
import com.codegym.service.IDiemDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemDenService implements IDiemDenService {
    @Autowired
    private IDiemDenRepository diemDenRepository;

    @Override
    public List<DiemDen> getAll() {
        return diemDenRepository.getAll();

    }
}
