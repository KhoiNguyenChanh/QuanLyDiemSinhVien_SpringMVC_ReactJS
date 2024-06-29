/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.pojo.ScoreSv;
import java.util.List;

/**
 *
 * @author chanh
 */
public interface ScoresvService {

    List<ScoreSv> getScores();

    List<ScoreSv> getScoreByLophocId(Long score_class_Id);

}
