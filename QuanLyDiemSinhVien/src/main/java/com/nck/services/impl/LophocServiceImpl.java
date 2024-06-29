/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.Lophoc;
import com.nck.repositories.LophocRepository;
import com.nck.services.LophocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class LophocServiceImpl implements LophocService{
    @Autowired
    private LophocRepository lophocRepo;

    @Override
    public List<Lophoc> getLophoc() {
        return this.lophocRepo.getLophoc();
    }

    @Override
    public Lophoc getLophocById(Long classId) {
        return this.lophocRepo.getLophocById(classId);
    }
    
}
