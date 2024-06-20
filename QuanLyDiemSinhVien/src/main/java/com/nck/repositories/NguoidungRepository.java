/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories;

import com.nck.pojo.Nguoidung;
import java.util.List;

/**
 *
 * @author chanh
 */
//public interface NguoidungRepository extends JpaRepository<Nguoidung, Long> {
public interface NguoidungRepository {
    List<Nguoidung> findByRole(String role);
}
