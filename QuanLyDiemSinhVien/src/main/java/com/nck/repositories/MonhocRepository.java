/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Monhoc;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author chanh
 */
public interface MonhocRepository {

    List<Monhoc> getMonhoc(Map<String, String> params);

    void addOrUpdate(Monhoc m);

    Monhoc getMonhocById(long id);

    //xóa nôi bô ko khoa ngoai
    void deleteMonhoc(long id);
//   List<Monhoc> getMonhoc();

    //chi tiet sinh vien
    Optional<Monhoc> findById(Long id);

    List<Monhoc> findAll();

    Long getLopHocId(Long id);

    Long getMonHocId(Long id);

    // Tìm người dùng là giảng viên
//    List<Monhoc> findGiangVien();
}
