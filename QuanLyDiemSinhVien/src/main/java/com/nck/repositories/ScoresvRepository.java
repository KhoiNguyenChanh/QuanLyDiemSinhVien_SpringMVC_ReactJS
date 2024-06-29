/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.ScoreSv;
import java.util.List;

/**
 *
 * @author chanh
 */
public interface ScoresvRepository {
    List<ScoreSv> getScores();
    List<ScoreSv> getScoreByLophocId(Long score_class_Id);
    //chi tiet sinh vine
     List<ScoreSv> findBySinhVienIdAndLopHocId(Long sinhVienId, Long lopHocId);

}
