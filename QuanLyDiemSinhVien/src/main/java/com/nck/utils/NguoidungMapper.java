/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.utils;

import com.nck.dto.NguoidungDTO;
import com.nck.pojo.Nguoidung;

/**
 *
 * @author chanh
 */
public class NguoidungMapper {
     public static NguoidungDTO toDTO(Nguoidung nguoidung) {
        NguoidungDTO dto = new NguoidungDTO();
        dto.setId(nguoidung.getId());
        dto.setTen(nguoidung.getTen());
        dto.setEmail(nguoidung.getEmail());
        dto.setSdt(nguoidung.getSdt());
        dto.setUsername(nguoidung.getUsername());
        dto.setActive(nguoidung.getActive());
        dto.setRole(nguoidung.getRole());
        dto.setAvatar(nguoidung.getAvatar());
        return dto;
    }

    public static Nguoidung toEntity(NguoidungDTO dto) {
        Nguoidung nguoidung = new Nguoidung();
        nguoidung.setId(dto.getId());
        nguoidung.setTen(dto.getTen());
        nguoidung.setEmail(dto.getEmail());
        nguoidung.setSdt(dto.getSdt());
        nguoidung.setUsername(dto.getUsername());
        nguoidung.setActive(dto.getActive());
        nguoidung.setRole(dto.getRole());
        nguoidung.setAvatar(dto.getAvatar());
        return nguoidung;
    }
}
