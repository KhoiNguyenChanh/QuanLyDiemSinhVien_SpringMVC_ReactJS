/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.pojo.Lophoc;
import java.util.List;

/**
 *
 * @author chanh
 */
public interface LophocService {

    List<Lophoc> getLophoc();

    Lophoc getLophocById(Long classId);

}
