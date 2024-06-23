/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.formatters;

import com.nck.pojo.Nguoidung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author chanh
 */
public class NguoidungFormatter implements Formatter<Nguoidung>{

    @Override
    public String print(Nguoidung nguoidung, Locale locale) {
        return String.valueOf(nguoidung.getId());
    }

    @Override
    public Nguoidung parse(String id, Locale locale) throws ParseException {
        Nguoidung n = new Nguoidung();
        n.setId(Long.parseLong(id));
        return n;
    }
    
}
