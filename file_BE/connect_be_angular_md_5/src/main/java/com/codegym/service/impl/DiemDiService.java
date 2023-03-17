package com.codegym.service.impl;

import com.codegym.model.DiemDi;
import com.codegym.repository.IDiemDiRepository;
import com.codegym.service.IDiemDenService;
import com.codegym.service.IDiemDiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemDiService implements IDiemDiService {
    @Autowired
    private IDiemDiRepository diemDiRepository;

    @Override
    public List<DiemDi> getAll() {
        return diemDiRepository.getAll();

    }
}
