/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.DanhMucMonHoc;
import com.nck.pojo.Monhoc;
import com.nck.services.MonhocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chanh
 */
@RestController
@RequestMapping("/api" )
public class ApiMonhocController {

    @Autowired
    //thuc hien javascript tren java :1
    private MonhocService monhocService;

    @DeleteMapping("/monhocs/{monhocId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "monhocId") long id) {
        this.monhocService.deleteMonhoc(id);
    }
    @GetMapping("/monhocs/")
    @CrossOrigin
    public ResponseEntity<List<Monhoc>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.monhocService.getMonhoc(params), HttpStatus.OK);
    }
    
    @GetMapping(path = "/monhocs/{monhocId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Monhoc> retrieve(@PathVariable(value = "monhocId") long id){
        return new ResponseEntity<>(this.monhocService.getMonhocById(id), HttpStatus.OK);
    }
    
}
