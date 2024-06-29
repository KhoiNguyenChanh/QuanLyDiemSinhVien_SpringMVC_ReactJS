/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.controllers;

import com.nck.pojo.Lophoc;
import com.nck.pojo.ScoreSv;
import com.nck.services.LophocService;
import com.nck.services.ScoresvService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chanh
 */
@Controller
public class Scoresv_ClassController {
    @Autowired
    private LophocService lophocService;

    @Autowired
    private ScoresvService scoresvService; 
    
    @GetMapping("/monhocdetails/{id}")
    public String getMonhocDetails(@PathVariable("id") Long id, Model model) {
        Lophoc lophoc = lophocService.getLophocById(id);
        List<ScoreSv> scores = scoresvService.getScoreByLophocId(id);
        model.addAttribute("lophoc", lophoc);
        model.addAttribute("scores", scores);
        return "monhocDetails";
    }
}
