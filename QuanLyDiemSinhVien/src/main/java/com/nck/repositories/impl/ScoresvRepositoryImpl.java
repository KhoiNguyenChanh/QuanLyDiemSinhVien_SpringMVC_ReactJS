/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.ScoreSv;
import com.nck.repositories.ScoresvRepository;
import java.awt.Robot;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chanh
 */
@Repository
@Transactional
public class ScoresvRepositoryImpl implements ScoresvRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ScoreSv> getScores() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("ScoreSv.findAll");

        return q.getResultList();
    }

    @Override
    public List<ScoreSv> getScoreByLophocId(Long score_class_Id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ScoreSv> cq = b.createQuery(ScoreSv.class);
        Root<ScoreSv> root = cq.from(ScoreSv.class);
        cq.where(b.equal(root.get("lophocId"), score_class_Id));
        return s.createQuery(cq).getResultList();
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ScoreSv> findBySinhVienIdAndLopHocId(Long sinhVienId, Long lopHocId) {
        return entityManager.createQuery("SELECT s FROM ScoreSv s WHERE s.sinhVienId = :sinhVienId AND s.lopHocId = :lopHocId", ScoreSv.class)
                .setParameter("sinhVienId", sinhVienId)
                .setParameter("lopHocId", lopHocId)
                .getResultList();
    }

}
