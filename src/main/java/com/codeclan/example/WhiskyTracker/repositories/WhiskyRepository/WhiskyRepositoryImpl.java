package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;



public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {



    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getAllWhiskiesFromRegion(String region){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distillery");
            cr.add(Restrictions.eq("distillery.region", region));
            results = cr.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    //@Autowired
   // EntityManager entityManager;

//    @Transactional
//    public List<Whisky> findWhiskyFromDistilleryByAge(Long distillery_id, int age){
//        List<Whisky> result = null;
//
//        Session session = entityManager.unwrap(Session.class);
//
//        try{
//            Criteria cr = session.createCriteria(Whisky.class);
//            cr.createAlias("distillery", "distilleryAlias");
//            cr.add(Restrictions.eq("distilleryAlias.id", distillery_id ));
//            cr.add(Restrictions.eq("age", age));
//
//            result = cr.list();
//        }
//
//        catch (HibernateException ex) {
//            ex.printStackTrace();
//
//
//        }
//
//        return result;
//    }


}
