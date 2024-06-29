/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.Monhoc;
import com.nck.pojo.Nguoidung;
import com.nck.services.MonhocService;
import com.nck.services.NguoidungService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author chanh
 */
@Controller
public class MonhocDetailsController {

    @Autowired
    private MonhocService monhocService;
    @Autowired
    private NguoidungService nguoidungService;
//
//    @GetMapping("/monhocdetails/{id}")
//    public String getMonHocDetails(@PathVariable("id") Long id, Model model) {
//        // Lấy thông tin môn học
//        Monhoc monhoc = monhocService.getMonhocById(id);
//        if (monhoc == null) {
//            model.addAttribute("error", "Không tìm thấy môn học");
//            return "monhocdetails";
//        }
//
//        // Lấy thông tin giảng viên phụ trách môn học
//        Nguoidung giangVien = nguoidungService.getMonhocById(id);
//        if (giangVien == null) {
//            model.addAttribute("error", "Không tìm thấy giảng viên phụ trách môn học");
//            return "monhocdetails";
//        }
//
//        model.addAttribute("monhoc", monhoc);
//        model.addAttribute("giangvien", giangVien);
//        return "monhocdetails";
//    }
//

    @RequestMapping("/monhocdetails")
    public String monhocdetails(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("user", this.nguoidungService.getUser(params));
        return "monhocdetails";
    }
//
//    @RequestMapping("/monhocdetails")
//    public String monhocTitle(@RequestParam("id") int id, Model model) {
//        Monhoc monhoc = this.monhocService.getMonhocById(id);
//        model.addAttribute("monhoc", monhoc);
//        model.addAttribute("giangvien", monhoc.getNguoidung()); // Giả sử Nguoidung là giảng viên phụ trách môn học
//        return "monhocdetails"; // Tên của JSP file
//    }
//     @RequestMapping("/monhocdetails")
//    public String monhocdetails(@RequestParam Map<String, String> params, @RequestParam("id") long id, Model model) {
//        // Lấy thông tin user
//         model.addAttribute("user", this.nguoidungService.getUser(params));
//
//        if (id == null) {
//            model.addAttribute("error", "ID môn học không được cung cấp");
//            return "error"; // Bạn có thể tạo trang lỗi riêng
//        }
//
//        // Lấy thông tin môn học và giảng viên
//        Monhoc monhoc = this.monhocService.getMonhocById(id);
//        if (monhoc == null) {
//            model.addAttribute("error", "Không tìm thấy môn học");
//            return "monhocdetails";
//        }
//        model.addAttribute("monhoc", monhoc);
//        model.addAttribute("giangvien", monhoc.getNguoidung());
//
//        return "monhocdetails"; // Tên của JSP file
//    }

}
