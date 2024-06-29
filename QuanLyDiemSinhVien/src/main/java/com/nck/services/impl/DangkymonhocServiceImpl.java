/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.Dangkymonhoc;
import com.nck.repositories.DangkymonhocRepository;
import com.nck.services.DangkymonhocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class DangkymonhocServiceImpl implements DangkymonhocService{
    @Autowired
    private DangkymonhocRepository dangKyMonHocRepo;
    @Override
    public List<Dangkymonhoc> getDangkymonhoc() {
        return this.dangKyMonHocRepo.getDangkymonhoc();
    }
    
}
