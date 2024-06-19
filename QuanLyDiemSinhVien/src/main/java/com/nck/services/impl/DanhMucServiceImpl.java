/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.DanhMucMonHoc;
import com.nck.repositories.DanhMucRepositoriy;
import com.nck.services.DanhMucService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class DanhMucServiceImpl implements DanhMucService{
    @Autowired
    private DanhMucRepositoriy danhMucRepo;

    @Override
    public List<DanhMucMonHoc> getDanhMuc() {
        return this.danhMucRepo.getDanhMuc();    }
 
}
