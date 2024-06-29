/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.pojo.CotDiemThem;
import com.nck.repositories.CotDiemThemRepository;
import com.nck.services.CotDiemThemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chanh
 */
@Service
public class CotDiemThemServiceImpl implements CotDiemThemService{

    @Autowired 
    private CotDiemThemRepository cotDiemThemRepo;
    @Override
    public List<CotDiemThem> getCotDiemThem() {
        return this.cotDiemThemRepo.getCotDiemThem();
    }
    
}
