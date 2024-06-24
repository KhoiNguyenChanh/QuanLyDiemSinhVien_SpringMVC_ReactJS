/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.pojo.Nguoidung;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author chanh
 */
public interface NguoidungService extends UserDetailsService{
    
    Nguoidung getUserByUsername(String username);
    void addUser(Nguoidung user);
    void deleteUser(long id);
    List<Nguoidung> getGiangVien(); //find by role
    List<Nguoidung> getUser();

}
