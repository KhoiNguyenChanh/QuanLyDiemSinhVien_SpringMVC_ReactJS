/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.Lophoc;
import com.nck.pojo.ScoreSv;
import com.nck.repositories.LophocRepository;
import java.util.List;
import java.util.Optional;
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
public class LophocRepositoryImpl implements LophocRepository{
    @Autowired
     private LocalSessionFactoryBean factory;
     
    @Override
    public List<Lophoc> getLophoc() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Lophoc.findAll");
    
        return q.getResultList();    
    }

    @Override
    public Lophoc getLophocById(Long classId) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Lophoc.class, classId);
    }
    //chi tiet sinh vien
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Optional<Lophoc> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Lophoc.class, id));
    }

    @Override
    public List<Lophoc> findAll() {
         return entityManager.createQuery("SELECT l FROM Lophoc l", Lophoc.class)
                .getResultList();   
    }

    @Override
    public Long getMonHocId(Long id) {
        return entityManager.createQuery("SELECT l.monhoc.id FROM Lophoc l WHERE l.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Long getLopHocId(Long id) {
        return id;
    }
}
