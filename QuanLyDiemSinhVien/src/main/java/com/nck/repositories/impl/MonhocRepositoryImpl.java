/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.Monhoc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.nck.repositories.MonhocRepository;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chanh
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class MonhocRepositoryImpl implements MonhocRepository {

    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Autowired
    private Environment env;

    public List<Monhoc> getMonhoc(Map<String, String> params) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Monhoc> q = b.createQuery(Monhoc.class);
        Root r = q.from(Monhoc.class);
        q.select(r);

        //filter theo kw, predicate javax persistence criteria
        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("ten"), String.format("%%%s%%", kw)));
        }

        //theo id
        String monhocId = params.get("monhocId");
        if (monhocId != null && !monhocId.isEmpty()) {
            //root.get("ten bang (tableName = ("")) trong entity class
            predicates.add(b.equal(r.get("danhMucMonHoc"), Integer.parseInt(monhocId)));
        }
        //q.where(predicate.toarray(intfuntion<T[] genereator)
        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);

//        //phân trang, s? c?n cho vi?c phân trang svien
//        String p = params.get("page");
//        if (p != null && !p.isEmpty()) {
//            int pageSize = Integer.parseInt(env.getProperty("monhocs.pageSize").toString());
//            int start = (Integer.parseInt(p) - 1) * pageSize;
//            query.setFirstResult(start);
//            query.setMaxResults(pageSize);
//        }
        List<Monhoc> monhocs = query.getResultList();
        return monhocs;

    }

    @Override
    public Monhoc getMonhocById(long id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        return s.get(Monhoc.class, id);
    }

    @Override
    public void addOrUpdate(Monhoc m) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        if (m.getId() != null && m.getId() > 0) {
            s.update(m);
        } else {
            s.save(m);
        }
//        try {
//            if (m != null) {
//                s.update(m);
//            } else {
//                s.save(m);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
    }
//delete noi bo, chua delete khoa ngoai, de cho vui, sua sau

    @Override
    public void deleteMonhoc(long id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Monhoc m = this.getMonhocById(id);
        s.delete(m);

    }
    //chi tiet sinh vien
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Monhoc> findById(Long id) {
        //return Optional.ofNullable(entityManager.find(Monhoc.class, id));
        Monhoc monHoc = entityManager.find(Monhoc.class, id);
        return monHoc != null ? Optional.of(monHoc) : Optional.empty();
    }

    @Override
    public List<Monhoc> findAll() {
        return entityManager.createQuery("SELECT m FROM Monhoc m", Monhoc.class)
                .getResultList();
    }
//    @Override
//    public List<Monhoc> findGiangVien() {
//        String queryString = "SELECT m FROM Monhoc m JOIN m.nguoidung u WHERE u.role = 'giangvien'";
//        Query q = entityManager.createQuery(queryString, Monhoc.class);
//        return q.getResultList();
//    }

    @Override
    public Long getLopHocId(Long id) {
        return entityManager.createQuery("SELECT m.lophoc.id FROM Monhoc m WHERE m.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Long getMonHocId(Long id) {
       return id;
    }

}
