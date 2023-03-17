package com.codegym.controller;

import com.codegym.dto.BenXeDto;
import com.codegym.model.BenXe;
import com.codegym.service.IBenXeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/benXe")
public class BenXeRestController {
    @Autowired
    private IBenXeService benXeService;

    @GetMapping("")
    public ResponseEntity<Page<BenXe>> getAll(@PageableDefault(size = 2) Pageable pageable) {
        Page<BenXe> benXes = benXeService.getAll(pageable);
        if (benXes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benXes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BenXe> delete(@PathVariable("id") Integer id) {
        BenXe benXe = benXeService.findBenXeById(id);
        if (benXe == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        benXeService.deleteBenXe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenXe> findBenXeById(@PathVariable("id") Integer id) {
        BenXe benXe = benXeService.findBenXeById(id);
        if (benXe == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(benXe, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editBenXe(@RequestBody @Validated BenXeDto benXeDto, BindingResult bindingResult, @PathVariable("id") Integer id) {
        BenXe benXe = benXeService.findBenXeById(id);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        if (benXe == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(benXeDto, benXe);
        benXeService.editBenXe(benXe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBenXe(@RequestBody @Validated BenXeDto benXeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        BenXe benXe = new BenXe();
        BeanUtils.copyProperties(benXeDto, benXe);
        benXeService.addBenXe(benXe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<List<BenXe>> getList() {
        return new ResponseEntity<>(benXeService.getAllBenXe(), HttpStatus.OK);
    }
}
