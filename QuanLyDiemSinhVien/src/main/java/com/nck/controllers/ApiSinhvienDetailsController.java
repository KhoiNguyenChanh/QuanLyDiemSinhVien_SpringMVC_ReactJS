/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.dto.SinhvienInfo;
import com.nck.services.SinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chanh
 */
@RestController
@RequestMapping("/api")
public class ApiSinhvienDetailsController {
//    @Autowired
//    private SinhVienService sinhVienService;
//
//    @GetMapping("/sinhviendetails/{sinhvienId}")
//    public List<SinhvienInfo> getStudentDetails(@PathVariable Long sinhvienId) {
//        return sinhVienService.getStudentInfo(sinhvienId);
//    }
}
