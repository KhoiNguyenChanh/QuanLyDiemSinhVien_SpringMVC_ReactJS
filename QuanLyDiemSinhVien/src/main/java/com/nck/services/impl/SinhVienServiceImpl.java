/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.services.impl;

import com.nck.dto.SinhvienInfo;
import com.nck.pojo.Dangkymonhoc;
import com.nck.pojo.Lophoc;
import com.nck.pojo.Monhoc;
import com.nck.pojo.Nguoidung;
import com.nck.pojo.ScoreSv;
import com.nck.repositories.DangkymonhocRepository;
import com.nck.repositories.LophocRepository;
import com.nck.repositories.MonhocRepository;
import com.nck.repositories.NguoidungRepository;
import com.nck.repositories.ScoresvRepository;
import com.nck.services.SinhVienService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chanh
 */
@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private NguoidungRepository nguoiDungRepository;

    @Autowired
    private DangkymonhocRepository dangKyMonHocRepository;

    @Autowired
    private LophocRepository lopHocRepository;

    @Autowired
    private MonhocRepository monHocRepository;

    @Autowired
    private ScoresvRepository scoreSVRepository;

    @Override
    public List<SinhvienInfo> getStudentInfo(Long sinhvienId) {
        Nguoidung student = nguoiDungRepository.findById(sinhvienId).orElse(null);
        if (student == null) {
            return new ArrayList<>(); // Return an empty list if student not found
        }

        List<SinhvienInfo> studentInfos = new ArrayList<>();
        List<Dangkymonhoc> dangKyMonHocList = dangKyMonHocRepository.findBySinhVienId(student.getId());

        for (Dangkymonhoc dangKyMonHoc : dangKyMonHocList) {
            Lophoc lopHoc = getLophocFromDangkymonhoc(dangKyMonHoc);

            if (lopHoc != null) {
                Long monHocId = lopHocRepository.getMonHocId(lopHoc.getId());
                Monhoc monHoc = monHocRepository.findById(monHocId).orElse(null);

                if (monHoc != null) {
                    List<ScoreSv> scores = scoreSVRepository.findBySinhVienIdAndLopHocId(student.getId(), lopHoc.getId());

                    for (ScoreSv score : scores) {
                        SinhvienInfo info = new SinhvienInfo();
                        info.setStudentId(student.getId());
                        info.setStudentName(student.getTen());
                        info.setCourseName(monHoc.getTen());
                        info.setMidtermScore(score.getGiuaKy());
                        info.setFinalScore(score.getCuoiKy());
                        studentInfos.add(info);
                    }
                }
            }
        }

        return studentInfos;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private Lophoc getLophocFromDangkymonhoc(Dangkymonhoc dangKyMonHoc) {
        Query query = entityManager.createQuery(
                "SELECT d.lopHocId FROM Dangkymonhoc d WHERE d.id = :dangKyMonHocId", Lophoc.class)
                .setParameter("dangKyMonHocId", dangKyMonHoc.getId());

        return (Lophoc) query.getSingleResult();
    }
}
