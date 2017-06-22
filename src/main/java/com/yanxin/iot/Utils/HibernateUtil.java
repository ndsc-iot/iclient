package com.yanxin.iot.Utils;

import com.yanxin.iot.mariadb.beans.UserPO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Guozhen Cheng on 2017/6/11.
 */
public class HibernateUtil {

    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            log.info("Hibernate session factory is inited.");
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
           log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
    /*
    public static void main(String[] args) {

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        List<UserPO> users = session.createQuery("select u from UserPO u").list();
        tx.commit();
        log.info("--------------------------------");
    }*/
}
