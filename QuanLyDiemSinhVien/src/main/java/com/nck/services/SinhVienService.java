/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services;

import com.nck.dto.SinhvienInfo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chanh
 */
public interface SinhVienService {
     List<SinhvienInfo> getStudentInfo(Long sinhvienId);
}
