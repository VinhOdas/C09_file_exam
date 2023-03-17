package com.codegym.controller;

import com.codegym.model.BenXe;
import com.codegym.service.IBenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("benXe")
public class BenXeRestController {
    @Autowired
    private IBenXeService benXeService;

    @GetMapping("")
    public ResponseEntity<List<BenXe>> getAll(@PageableDefault(size = 3) Pageable pageable) {
        List<BenXe> benXes = benXeService.getAllBenXe();
        if (benXes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benXes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BenXe> delete(@PathVariable("id") Integer id) {
        BenXe benXe = benXeService.findBenXeById(id);
        if (benXe == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        benXeService.deleteBenXe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
