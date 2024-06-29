/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nck.repositories.impl;

import com.nck.pojo.Nguoidung;
import com.nck.repositories.NguoidungRepository;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chanh
 */
@Repository
@Transactional
public class NguoidungRepositoryImpl implements NguoidungRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private Environment env;

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

    @Override
    public Nguoidung getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        //Query q = s.createNamedQuery("Nguoidung.findByUsername");
        Query q = s.createQuery("FROM Nguoidung WHERE username = :username");

        q.setParameter("username", username);
        return (Nguoidung) q.getSingleResult();
    }

    @Override
    public void addUser(Nguoidung user) {
        Session s = this.factory.getObject().getCurrentSession();
        if (user.getId() != null && user.getId() > 0) {
            s.update(user);
        } else {
            s.save(user);
        }
    }

    @Override
    public void deleteUser(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Nguoidung u = this.getUserById(id);
        s.delete(u);
    }

    @Override
    public Nguoidung getUserById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Nguoidung.class, id);
    }

    @Override
    public List<Nguoidung> getUser(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> q = b.createQuery(Nguoidung.class);
        Root r = q.from(Nguoidung.class);
        q.select(r);

        //filter theo kw, predicate javax persistence criteria
        List<Predicate> predicates = new ArrayList<>();
        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("ten"), String.format("%%%s%%", kw)));
        }

        //theo id
        String userId = params.get("userId");
        if (userId != null && !userId.isEmpty()) {
            //root.get("ten bang (tableName = ("")) trong entity class
            predicates.add(b.equal(r.get("ten"), Integer.parseInt(userId)));
            // predicates.add(b.equal(r.get("id"), Integer.parseInt(userId)));

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
        List<Nguoidung> user = query.getResultList();
        return user;
    }

//    @Override
//    public Nguoidung getMonhocById(Long id) {
//        Session s = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder b = s.getCriteriaBuilder();
//        CriteriaQuery<Nguoidung> q = b.createQuery(Nguoidung.class);
//        Root r = q.from(Nguoidung.class);
//        q.select(r).where(b.equal(r.get("id"),id));
//        
//        return s.createQuery(q).uniqueResult();
//    }
    @Override
    public boolean authUser(String username, String password) {
        Nguoidung u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public Optional<Nguoidung> findById(Long id) {
        Session session = this.factory.getObject().getCurrentSession();
        Nguoidung nguoidung = session.get(Nguoidung.class, id);
        return Optional.ofNullable(nguoidung);
    }

}
