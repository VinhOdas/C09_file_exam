package com.codegym.controller;

import com.codegym.model.LoaiXe;
import com.codegym.model.NhaXe;
import com.codegym.service.ILoaiXeService;
import com.codegym.service.INhaXeService;
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
@RequestMapping("nhaXe")
public class NhaXeRestController {
    @Autowired
    private INhaXeService nhaXeService;

    @GetMapping("")
    public ResponseEntity<List<NhaXe>> getAll() {
        List<NhaXe> nhaXes = nhaXeService.getAll();
        if (nhaXes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nhaXes,HttpStatus.OK);
    }
}
