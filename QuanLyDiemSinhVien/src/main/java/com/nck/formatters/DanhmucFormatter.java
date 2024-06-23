/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.formatters;

import com.nck.pojo.DanhMucMonHoc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author chanh
 */
public class DanhmucFormatter implements Formatter<DanhMucMonHoc >{

    @Override
    public String print(DanhMucMonHoc danhmuc, Locale locale) {
        return String.valueOf(danhmuc.getId());
    }

    @Override
    public DanhMucMonHoc parse(String id, Locale locale) throws ParseException {
        DanhMucMonHoc d = new DanhMucMonHoc();
        d.setId(Long.parseLong(id)); 
    //dang le la integer.parseint(id), nhung lo de id thanh long r :1
    //can than coi chung khi them id thành int se loi 
        return d;
    }
    
}
