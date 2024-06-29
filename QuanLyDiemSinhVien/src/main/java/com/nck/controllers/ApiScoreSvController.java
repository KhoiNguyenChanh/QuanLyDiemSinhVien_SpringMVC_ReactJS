/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.ScoreSv;
import com.nck.services.ScoresvService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chanh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiScoreSvController {
//     @Autowired
//    private ScoresvService scoresvService;
//    @GetMapping("/scoresv/")
//    @CrossOrigin
//    public ResponseEntity<List<ScoreSv>> list(@RequestParam Map<String, String> params) {
////        return new ResponseEntity<>(this.scoresvService.getScores(params), HttpStatus.OK);
//   }
}
