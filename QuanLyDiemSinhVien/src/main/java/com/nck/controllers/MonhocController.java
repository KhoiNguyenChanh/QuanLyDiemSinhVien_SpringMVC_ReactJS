/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.Monhoc;
import com.nck.services.DanhMucService;
import com.nck.services.MonhocService;
import com.nck.services.NguoidungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author chanh
 */
@Controller
public class MonhocController {

    @Autowired
    private MonhocService monhocService;

    @GetMapping("/monhocs")
    public String createView(Model model) {
        model.addAttribute("monhocs", new Monhoc());

        //return name in tiles file
        return "monhocs";
    }

    @PostMapping("/monhocs")
    public String createMonhoc(@ModelAttribute("monhocs") Monhoc m) {
        System.out.println("Tên môn học từ form: " + m.getTen());    
        monhocService.addOrUpdate(m);
            // Redirect về trang chủ sau khi thêm thành công
            return "redirect:/";
        
    }
//    @PostMapping("/monhocs")
//    public String createMonhoc(@ModelAttribute(value = "monhoc") Monhoc m) {
//        // Redirect về trang chủ
//        return "redirect:/";
//
////        return "...";
//    }
}
