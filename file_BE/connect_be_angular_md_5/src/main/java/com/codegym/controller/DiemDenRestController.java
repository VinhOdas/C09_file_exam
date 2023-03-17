package com.codegym.controller;

import com.codegym.model.DiemDen;
import com.codegym.model.DiemDi;
import com.codegym.model.LoaiXe;
import com.codegym.service.IDiemDenService;
import com.codegym.service.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("diemDen")
public class DiemDenRestController {
    @Autowired
    private IDiemDenService diemDenService;

    @GetMapping("")
    public ResponseEntity<List<DiemDen>> getAll() {
        List<DiemDen> diemDens = diemDenService.getAll();
        if (diemDens.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(diemDens,HttpStatus.OK);
    }
}
