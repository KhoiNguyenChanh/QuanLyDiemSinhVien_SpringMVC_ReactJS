/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.components.JwtService;
import com.nck.pojo.Nguoidung;
import com.nck.services.NguoidungService;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author chanh
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private NguoidungService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/users")
    public String createView(Model model) {
        model.addAttribute("user", new Nguoidung());
        return "users";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("users") @Valid Nguoidung u,
            BindingResult rs) {
        System.out.println(u.getTen());
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userService.addUser(u);
        if (!rs.hasErrors()) {
            try {
                this.userService.addUser(u);
                return "redirect:/"; //ko có redirect ve "" hay "..." dc:(
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.out.println(ex);
            }
        }
        // Redirect về trang chủ sau khi thêm thành công
        return "users";
    }

//      // Trang đăng ký người dùng
//    @GetMapping("/users")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new Nguoidung());
//        return "users";
//    }
//
//    // Xử lý đăng ký người dùng mới
//    @PostMapping("/users")
//    public String registerUser(@ModelAttribute("user") Nguoidung user, @RequestPart("file") MultipartFile[] file) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole("giangvien");
//        user.setActive(true);
//        if (file.length > 0) {
//            user.setFile(file[0]);
//        }
//        
//        userService.addUser(user);
//        return "redirect:/login";
//    }
//
//    // Trang đăng nhập
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }
//
//    // Xử lý đăng nhập
//    @PostMapping("/login")
//    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
//        if (userService.authUser(username, password)) {
//            String token = jwtService.generateTokenLogin(username);
//            request.getSession().setAttribute("token", token);
//            return "redirect:/home";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
//
//    // Trang người dùng hiện tại
//    @GetMapping("/current-user")
//    public String getCurrentUser(Principal principal, Model model) {
//        Nguoidung user = userService.getUserByUsername(principal.getName());
//        model.addAttribute("user", user);
//        return "userProfile";
//    }
    @GetMapping("/users/{userId}")
    public String updateView(Model model, @PathVariable(value = "userId") long id) {

        model.addAttribute("users", this.userService.getUserById(id));
        return "users";

    }
}
