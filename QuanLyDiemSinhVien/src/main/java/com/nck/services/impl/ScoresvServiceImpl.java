/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.ScoreSv;
import com.nck.repositories.ScoresvRepository;
import com.nck.services.ScoresvService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class ScoresvServiceImpl implements ScoresvService {

    @Autowired
    private ScoresvRepository ScoresvRepo;

    @Override
    public List<ScoreSv> getScores() {
        return this.ScoresvRepo.getScores();
    }

    @Override
    public List<ScoreSv> getScoreByLophocId(Long score_class_Id) {
        return this.ScoresvRepo.getScoreByLophocId(score_class_Id);
    }

}
