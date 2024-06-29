/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.dto.NguoidungDTO;
import com.nck.pojo.Nguoidung;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author chanh
 */
public interface NguoidungService extends UserDetailsService {

    Nguoidung getUserByUsername(String username);

    List<Nguoidung> getUser(Map<String, String> params);

    Nguoidung getUserById(long id);

    void addUser(Nguoidung user);

    void deleteUser(long id);

    List<Nguoidung> getGiangVien(); //find by role

    boolean authUser(String username, String password);
//    Nguoidung getMonhocById(Long id);

    public List<Nguoidung> getUser();

    NguoidungDTO convertToDTO(Nguoidung nguoidung);

    List<NguoidungDTO> convertToDTOList(List<Nguoidung> nguoidungList);

    NguoidungDTO findNguoidungDTOById(Long id);
}
