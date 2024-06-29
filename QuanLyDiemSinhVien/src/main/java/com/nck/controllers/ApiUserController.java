/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.components.JwtService;
import com.nck.dto.NguoidungDTO;
import com.nck.pojo.Nguoidung;
import com.nck.services.NguoidungService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author chanh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    @Autowired
//    private NguoidungService userService;
////
//    @PostMapping(path = "/users/", consumes = {
//        MediaType.APPLICATION_JSON_VALUE,
//        MediaType.MULTIPART_FORM_DATA_VALUE,})
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
//        Nguoidung u = new Nguoidung();
//        u.setTen(params.get("ten"));
//        u.setEmail(params.get("email")); //email buoc phai co
//        u.setSdt(params.get("sdt"));
//        u.setUsername(params.get("username"));
//        String password = params.get("password");
//        u.setPassword(this.passwordEncoder.encode(password));
//        //u.setRole("giangvien"); //tao giang vien
//        u.setRole(params.get("role")); // tao sinh vien/ giang vien
//        u.setActive(true);
//        if (file.length > 0) {
//            u.setFile(file[0]);
//
//        }
//        this.userService.addUser(u);
//    }
//
//    //delete ch?y ôn
//    @DeleteMapping("/users/{userId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(Model model, @PathVariable(value = "userId") long id) {
//        this.userService.deleteUser(id);
//    }
//
////    @GetMapping("/users/")
////    @CrossOrigin
////    public ResponseEntity<List<Nguoidung>> list(@RequestParam Map<String, String> params) {
////        return new ResponseEntity<>(this.userService.getUser(params), HttpStatus.OK);
////    }
////    
////    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<Nguoidung> retrieve(@PathVariable(value = "userId") long id){
////        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
////    }
//    @GetMapping("/users/")
//    @CrossOrigin
//    public ResponseEntity<List<NguoidungDTO>> list(@RequestParam Map<String, String> params) {
//        List<Nguoidung> users = this.userService.getUser(params);
//        List<NguoidungDTO> userDTOs = this.userService.convertToDTOList(users);
//        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
//    }
//
//    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<NguoidungDTO> retrieve(@PathVariable(value = "userId") long id) {
//        NguoidungDTO userDTO = this.userService.findNguoidungDTOById(id);
//        return new ResponseEntity<>(userDTO, HttpStatus.OK);
//    }
    @Autowired
    private BCryptPasswordEncoder passswordEncoder;
    @Autowired
    private NguoidungService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/users/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        Nguoidung u = new Nguoidung();
        u.setTen(params.get("ten"));
        u.setEmail(params.get("email")); //email buoc phai co
        u.setSdt(params.get("sdt"));
        u.setUsername(params.get("username"));
        String password = params.get("password");
        u.setPassword(this.passswordEncoder.encode(password));
        //u.setRole("giangvien"); //tao giang vien
        u.setRole(params.get("role")); // tao sinh vien/ giang vien
        u.setActive(true);
        if (file.length > 0) {
            u.setFile(file[0]);

        }
        this.userService.addUser(u);
    }

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Nguoidung user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Nguoidung> getCurrentUser(Principal p) {
        Nguoidung u = this.userService.getUserByUsername(p.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    //phuongthuc get
    @GetMapping("/users/")
    @CrossOrigin
    public ResponseEntity<List<Nguoidung>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getUser(params), HttpStatus.OK);
    }
    
    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Nguoidung> retrieve(@PathVariable(value = "userId") long id){
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }
    //phuongthuc delete
    //delete ch?y ôn
    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "userId") long id) {
        this.userService.deleteUser(id);
    }

}
