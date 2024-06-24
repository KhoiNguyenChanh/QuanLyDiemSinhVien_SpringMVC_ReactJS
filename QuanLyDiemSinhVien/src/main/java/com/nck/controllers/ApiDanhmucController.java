/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.DanhMucMonHoc;
import com.nck.services.DanhMucService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chanh
 */
@RestController 
@RequestMapping("/api")
public class ApiDanhmucController {
    @Autowired
    private DanhMucService danhmucService;
    
    @GetMapping("/danhmuc/")
    @CrossOrigin
    public ResponseEntity<List<DanhMucMonHoc>> list() {
        return new ResponseEntity<>(this.danhmucService.getDanhMuc(), HttpStatus.OK);
    }
    
    
}
