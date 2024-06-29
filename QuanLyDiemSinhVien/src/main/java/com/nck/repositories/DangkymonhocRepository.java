/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Dangkymonhoc;
import java.util.List;

/**
 *
 * @author chanh
 */
public interface DangkymonhocRepository {
    List<Dangkymonhoc> getDangkymonhoc();
    
    //chitietsinhvien
    List<Dangkymonhoc> findBySinhVienId(Long sinhVienId);
}
