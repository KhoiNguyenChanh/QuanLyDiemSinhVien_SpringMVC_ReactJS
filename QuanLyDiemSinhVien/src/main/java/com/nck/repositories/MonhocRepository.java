/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Monhoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chanh
 */
public interface MonhocRepository {
    List<Monhoc> getMonhoc(Map<String, String> params);
    void addOrUpdate (Monhoc m);
    Monhoc getMonhocById(long id);
    //xóa nôi bô ko khoa ngoai
    void deleteMonhoc(long id);
//   List<Monhoc> getMonhoc();
}
