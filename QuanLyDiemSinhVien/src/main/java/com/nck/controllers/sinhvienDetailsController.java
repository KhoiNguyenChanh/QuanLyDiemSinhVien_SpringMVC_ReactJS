/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.dto.SinhvienInfo;
import com.nck.services.SinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chanh
 */
@Controller
public class sinhvienDetailsController {
    @Autowired
    private SinhVienService sinhVienService;

//    @GetMapping("/sinhvienDetails/{sinhvienId}")
//    public String getStudentDetails(@PathVariable(value = "sinhvienId") Long sinhvienId, Model model) {
//        List<SinhvienInfo> studentInfos = sinhVienService.getStudentInfo(sinhvienId);
//        
//        // Add student details to model
//        model.addAttribute("studentInfos", studentInfos);
//        model.addAttribute("sinhvienId", sinhvienId);
//        
//        return "sinhvienDetails";
//    }
    private List<SinhvienInfo> fetchStudentDetails(Long sinhvienId) {
        return sinhVienService.getStudentInfo(sinhvienId);
    }

    // Phương thức để xử lý yêu cầu và thêm chi tiết sinh viên vào model
    @GetMapping("/sinhvienDetails/{sinhvienId}")
    public String getStudentDetails(Model model, @PathVariable(value = "sinhvienId") Long sinhvienId) {
        // Gọi phương thức để lấy chi tiết sinh viên
        List<SinhvienInfo> studentInfos = fetchStudentDetails(sinhvienId);

        // Thêm chi tiết sinh viên vào model
        addStudentDetailsToModel(studentInfos, sinhvienId, model);

        return "sinhvienDetails";
    }

    // Phương thức để thêm chi tiết sinh viên vào model
    private void addStudentDetailsToModel(List<SinhvienInfo> studentInfos, Long sinhvienId, Model model) {
        model.addAttribute("studentInfos", studentInfos);
        model.addAttribute("sinhvienId", sinhvienId);
    }

}
