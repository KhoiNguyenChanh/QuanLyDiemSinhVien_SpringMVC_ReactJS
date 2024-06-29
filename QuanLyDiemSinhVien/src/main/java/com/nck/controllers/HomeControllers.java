/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.Monhoc;
import com.nck.pojo.Nguoidung;
import com.nck.services.DanhMucService;
import com.nck.services.MonhocService;
import com.nck.services.NguoidungService;
import com.nck.services.ScoresvService;
import java.security.Principal;
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
    @Autowired
    private ScoresvService scoresvService;

    //nho model attribure, tat ca cac model/ pages deu se co phan danh muc
    @ModelAttribute
    public void commonAttr(Model model, Principal principal) {
        model.addAttribute("danhmuc", this.danhmucService.getDanhMuc());
        model.addAttribute("giangvien", nguoidungService.getGiangVien());
        model.addAttribute("user", nguoidungService.getUser());
        model.addAttribute("scoresv", scoresvService.getScores());
        
        //kiem tra phai co dang nhap moi cho dung button
         if (principal != null) {
            String username = principal.getName();
            Nguoidung loggedInUser = nguoidungService.getUserByUsername(username); // Assume you have this method in your service
            model.addAttribute("loggedInUser", loggedInUser);
        }
    }

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("monhoc", this.monhocService.getMonhoc(params));

        return "index";
    }
    
}
