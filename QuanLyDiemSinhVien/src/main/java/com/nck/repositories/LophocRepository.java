/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Lophoc;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author chanh
 */
public interface LophocRepository {

    List<Lophoc> getLophoc();

    Lophoc getLophocById(Long classId);

    //chi tiet sinh vien
    Optional<Lophoc> findById(Long id);

    List<Lophoc> findAll();

    Long getMonHocId(Long id);

    Long getLopHocId(Long id);

}
