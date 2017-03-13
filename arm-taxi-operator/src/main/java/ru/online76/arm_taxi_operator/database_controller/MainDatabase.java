package ru.online76.arm_taxi_operator.database_controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.online76.arm_taxi_operator.model.Cars;

import ru.online76.arm_taxi_operator.model.Orders;
import ru.online76.arm_taxi_operator.model.Document;
import ru.online76.arm_taxi_operator.model.Operators;

@Repository
public class MainDatabase {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public ArrayList<String> getDictionaryWorkTypeItems() {
        ArrayList<String> result = new ArrayList<String>();

        /*try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(social_category.class);
			//criteria.add(Restrictions.idEq(pat.getPid()));
			//session.beginTransaction();
			List<social_category> list = criteria.list();

			for (int i=0; i<list.size(); i++){
	        	result.add(list.get(i).name);
	        }
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
        
         */
        return result;
    }

    @Transactional
    public List getDictionaryOperatorsItems() {
        List result = null;

        try {

            Session session = sessionFactory.getCurrentSession();
            org.hibernate.Criteria criteria = session.createCriteria(Operators.class);
            //criteria.add(Restrictions.idEq(pat.getPid()));
            //session.beginTransaction();
            result = criteria.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw e;
        }

        return result;
    }

    @Transactional
    public List<Orders> getWorkOrdersList(String sort_field_name, String sort_direction) {
        List<Orders> result = new ArrayList<Orders>();

        try {

            System.out.println("getWorkOrdersList:sort_field_name=" + sort_field_name);

            Session session = sessionFactory.getCurrentSession();
            org.hibernate.Criteria criteria = session.createCriteria(Orders.class);
            criteria.add(Restrictions.sqlRestriction("dtArrive>getdate()-24.0/24"));
            if (sort_field_name != null) {
                if (sort_direction.compareTo("asc") == 0) {
                    criteria.addOrder(org.hibernate.criterion.Order.asc(sort_field_name));
                } else {
                    criteria.addOrder(org.hibernate.criterion.Order.desc(sort_field_name));
                }
            }
            //session.beginTransaction();
            result = criteria.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return result;
    }

    @Transactional
    public List<Cars> getOnlineCars() {
        List<Cars> result = new ArrayList<Cars>();

        try {

            Session session = sessionFactory.getCurrentSession();
            org.hibernate.Criteria criteria = session.createCriteria(Cars.class);
            //	criteria.add(Restrictions.sqlRestriction("dtArrive>getdate()-1.0/24"));

            //session.beginTransaction();
            result = criteria.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return result;
    }

    @Transactional
    public List<Document> getDocumentList() {
        List<Document> result;
        try {
            Session session = sessionFactory.getCurrentSession();
            org.hibernate.Criteria criteria = session.createCriteria(Document.class);
            //criteria.add(Restrictions.idEq(pat.getPid()));
            //session.beginTransaction();
            result = criteria.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return result;
    }

    @Transactional
    public Object get(Class objectClass, Integer ID) {
        Object saveResult = false;

        try {
            Session session = sessionFactory.getCurrentSession();
            saveResult = session.get(objectClass, ID);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return saveResult;
    }

    @Transactional
    public Serializable save(Object object) {
        Serializable saveResult = false;

        try {
            Session session = sessionFactory.getCurrentSession();
            saveResult = session.save(object);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return saveResult;
    }
    
    
    @Transactional
    public Serializable merge(Object object) {
        Serializable saveResult = false;

        try {
            Session session = sessionFactory.getCurrentSession();
            object = session.merge(object);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return saveResult;
    }

    @Transactional
    public Serializable merge_and_save(Object object) {
        Serializable saveResult = false;

        try {
            Session session = sessionFactory.getCurrentSession();

            //object = session.merge(object);
            // if ( session.contains( object ) ) {
            // nothing to do... myEntity is already associated with the session
            // }
            // else {
            session.saveOrUpdate(object);
//}

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return saveResult;
    }

}
