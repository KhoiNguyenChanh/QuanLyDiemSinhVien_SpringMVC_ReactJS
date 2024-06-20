/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.services.DanhMucService;
import com.nck.services.MonhocService;
import com.nck.services.NguoidungService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chanh
 */
@Controller
@ControllerAdvice
//controller advice, nhung cai common se dung chung cho cac controller :1..
public class HomeControllers {

    @Autowired
    private DanhMucService danhmucService;
    @Autowired
    private MonhocService monhocService;
    @Autowired
    private NguoidungService nguoidungService;

    //nho model attribure, tat ca cac model/ pages deu se co phan danh muc
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("danhmuc", this.danhmucService.getDanhMuc());
        model.addAttribute("giangvien", nguoidungService.getNguoidung());

    }

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("monhoc", this.monhocService.getMonhoc(params));

        return "index";
    }
}
