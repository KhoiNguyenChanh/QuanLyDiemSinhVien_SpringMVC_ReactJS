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
//    //just in case there's a 500
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    
//    @Override
//    public List<Monhoc> getMonhoc() {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createNamedQuery("Monhoc.findAll");
//    
//        return q.getResultList();    
//    }

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

    public Monhoc getMonhocById(int id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        return s.get(Monhoc.class, id);
    }

    public void addOrUpdate(Monhoc m) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        s.saveOrUpdate(m);
    }

    
}
//    @Autowired
//    private LocalSessionFactoryBean factoryBean;
//    @Autowired
//    private Environment env;
//    
//    public List<Monhoc> getMonhoc(Map<String, String> params) {
//        Session s = this.factoryBean.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Monhoc> q = b.createQuery(Monhoc.class);
//        Root r = q.from(Monhoc.class);
//        q.select(r);
//        
//        List<Predicate> predicates = new ArrayList<>();
//        
//        String kw = params.get("kw");
//        if (kw != null && !kw.isEmpty()) {
//            predicates.add(b.like(r.get("ten"), String.format("%%%s%%", kw)));
//        }
//        
//        String danhmucId = params.get("danhMucMonHoc");
//        if (danhmucId != null && !danhmucId.isEmpty()) {
//            predicates.add(b.equal(r.get("danhMucMonHoc"), Integer.parseInt(danhmucId)));
//        }
//        
//        q.where(predicates.toArray(Predicate[]::new));
//        q.orderBy(b.desc(r.get("id")));
//        
//        Query query = s.createQuery(q);
//        
//        String p = params.get("page");
//        if (p != null && !p.isEmpty()) {
//            int pageSize = Integer.parseInt(env.getProperty("Monhoc.pageSize").toString());
//            int start = (Integer.parseInt(p) - 1) * pageSize;
//            query.setFirstResult(start);
//            query.setMaxResults(pageSize);
//        }
//        
//        List<Monhoc> monhoc = query.getResultList();
//        
//        return monhoc;
//        
//    }
//    
//    public void addOrUpdate(Monhoc m) {
//        Session s = this.factoryBean.getObject().getCurrentSession();
//        s.saveOrUpdate(m);
//    }
//    
/*
        public List<Monhoc> getMonhocs(Map<String, String> params){
            try( Session session = Hibernateutils.getFactory().openSession()){
                CriteriaBuilder b = session.getcriteriaBuilder();
                CriteriaQuery<Product> q = b.createQuery(Monhoc.class);
                Root root = q.from(Monhoc.class);
                q.select(root);

                //filter theo kw, predicate javax persistence criteria
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()){
                    predicates.add(b.like(root.get("ten"), String.format("%%%s%%", kw)));
                }

                //theo id
                String monhocId = params.get("monhocId");
                if (monhocId != null && !monhocId.isEmpty()){
                //root.get("ten bang (tableName = ("")) trong entity class
                predicates.add(b.equal(root.get("danh_muc_mon_hoc").as(Integer.class), Integer.parseInt(monhocId)));
            }      
                //q.where(predicate.toarray(intfuntion<T[] genereator)
                q.where(predicates.toArray(Predicate[]::new));

                q.orderBy(b.desc(root.get("id"));
                Query query = session.createQuery(q);
                List<Monhoc> monhocs = query.getResultList();

                return monhocs;
            }   
        }
        public Monhoc getMonhocById(int id){
            try( Session session = Hibernateutils.getFactory().openSession()){
                return session.get(Monhoc.class, id);
            }       
        }
        public void addOrUpdate(Monhoc m){
            try( Session session = Hibernateutils.getFactory().openSession()){
                session.persist(m);
            }
        }

    
    }
 */
