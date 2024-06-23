/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.Nguoidung;
import com.nck.repositories.NguoidungRepository;
import java.util.List;
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
public class NguoidungRepositoryImpl implements NguoidungRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Nguoidung> findByRole(String role) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Nguoidung.findByRole");
        q.setParameter("role", role);

        return q.getResultList();
    }

    @Override
    public List<Nguoidung> getUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Nguoidung.findAll");
    
        return q.getResultList();     
    }

}
