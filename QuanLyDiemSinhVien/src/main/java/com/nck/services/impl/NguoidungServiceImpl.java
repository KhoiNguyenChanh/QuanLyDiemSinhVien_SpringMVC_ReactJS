/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.Nguoidung;
import com.nck.repositories.NguoidungRepository;
import com.nck.services.NguoidungService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class NguoidungServiceImpl implements NguoidungService{
    @Autowired
    private NguoidungRepository nguoidungRepository;

    @Override
    public List<Nguoidung> getNguoidung() {
        return nguoidungRepository.findByRole("giangvien");
    }
}
