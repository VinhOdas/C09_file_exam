package com.codegym.controller;

import com.codegym.model.BenXe;
import com.codegym.model.LoaiXe;
import com.codegym.service.IBenXeService;
import com.codegym.service.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("loaiXe")
public class LoaiXeRestController {
    @Autowired
    private ILoaiXeService loaiXeService;

    @GetMapping("")
    public ResponseEntity<List<LoaiXe>> getAll() {
        List<LoaiXe> loaiXes = loaiXeService.getAll();
        if (loaiXes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(loaiXes,HttpStatus.OK);
    }
}
