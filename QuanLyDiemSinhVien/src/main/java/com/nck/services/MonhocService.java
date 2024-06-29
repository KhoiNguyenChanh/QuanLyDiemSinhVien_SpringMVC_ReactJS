/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.pojo.Monhoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chanh
 */
public interface MonhocService {
//    List<Monhoc> getMonhoc();

    List<Monhoc> getMonhoc(Map<String, String> params);

    void addOrUpdate(Monhoc m);

    Monhoc getMonhocById(long id);

    //delete noi bo, chua delete khoa ngoai, de cho vui, sua sau
    void deleteMonhoc(long id);

//    List<Monhoc> findGiangVien();

}
