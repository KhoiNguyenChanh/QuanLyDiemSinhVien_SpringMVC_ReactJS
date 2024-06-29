/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.Monhoc;
import com.nck.repositories.MonhocRepository;
import org.springframework.stereotype.Service;
import com.nck.services.MonhocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author chanh
 */
@Service
public class MonhocServiceImpl implements MonhocService {

    @Autowired
    private MonhocRepository monhocRepo;

    @Override
    public List<Monhoc> getMonhoc(Map<String, String> params) {
        return this.monhocRepo.getMonhoc(params);
    }

    @Override
    public void addOrUpdate(Monhoc m) {
        this.monhocRepo.addOrUpdate(m);
    }

    
    //just in case it's not working 
//    @Autowired
//    private MonhocRepository monhocRepo;
//
//    @Override
//    public List<Monhoc> getMonhoc() {
//        return this.monhocRepo.getMonhoc();
//    }

    @Override
    public Monhoc getMonhocById(long id) {
        return this.monhocRepo.getMonhocById(id);
    }

    @Override
    public void deleteMonhoc(long id) {
        this.monhocRepo.deleteMonhoc(id);
    }

//    @Override
//    public List<Monhoc> findGiangVien() {
//        return this.monhocRepo.findGiangVien();
//    }

}
