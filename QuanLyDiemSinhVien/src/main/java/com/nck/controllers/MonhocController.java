/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.Monhoc;
import static com.nck.pojo.Monhoc_.tenGiangVien;
import com.nck.services.DanhMucService;
import com.nck.services.MonhocService;
import com.nck.services.NguoidungService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    //lõi:)
//    @PostMapping
//    public String createMonhoc(@ModelAttribute("monhocs") @Valid Monhoc m, BindingResult result) {
//        if (result.hasErrors()) {
//            return "monhocs";
//        }
//        monhocService.addOrUpdate(m);
//        return "redirect:/";
//    }
    @PostMapping("/monhocs")
    public String createMonhoc(@ModelAttribute("monhocs") @Valid Monhoc m,
            BindingResult rs) {
//        System.out.println("Tên môn học từ form: " + m.getTen());
//        //System.out.println("Tên môn học từ form: " + m.getMoTaMonHoc());
//
//        System.out.println("Tên giangvien: " + m.getTenGiangVien()); //ko get dc, chac do default la rong
//        System.out.println("Tên danh muc: " + m.getDanhMucMonHoc());
//        m.setTenGiangVien(m.getNguoidung().getTen());
//        m.setDanhMucMonHoc(m.getDanhMucMonHoc());
        // System.out.println("nguoidunggetname is: " + m.getNguoidung().getTen());//get dc, nhung khong luu dc

        monhocService.addOrUpdate(m);
        if (!rs.hasErrors()) {
            try {
                this.monhocService.addOrUpdate(m);
                return "redirect:/"; //ko có redirect ve "" hay "..." dc:(
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.out.println(ex);
            }
        }
        // Redirect về trang chủ sau khi thêm thành công
        return "monhocs";

    }
//  update view là c?p nhât s?n pahm (monhoc), vay la phai tao mot cai moi nho :1?

    @GetMapping("/monhocs/{monhocId}")
    public String updateView(Model model, @PathVariable(value = "monhocId") long id) {

        model.addAttribute("monhocs", this.monhocService.getMonhocById(id));
        return "monhocs";

    }
    

//    @PostMapping("/monhocs")
//    public String createMonhoc(@ModelAttribute(value = "monhoc") Monhoc m) {
//        // Redirect về trang chủ
//        return "redirect:/";
//
////        return "...";
//    }
}
