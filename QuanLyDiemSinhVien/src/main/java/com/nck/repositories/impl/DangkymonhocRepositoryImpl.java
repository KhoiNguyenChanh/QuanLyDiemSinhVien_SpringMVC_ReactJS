/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.Dangkymonhoc;
import com.nck.repositories.DangkymonhocRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class DangkymonhocRepositoryImpl implements DangkymonhocRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Dangkymonhoc> getDangkymonhoc() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Dangkymonhoc.findAll");

        return q.getResultList();
    }
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dangkymonhoc> findBySinhVienId(Long sinhVienId) {
       return entityManager.createQuery("SELECT d FROM Dangkymonhoc d WHERE d.sinhVienId = :sinhVienId", Dangkymonhoc.class)
                .setParameter("sinhVienId", sinhVienId)
                .getResultList();
    }

}
