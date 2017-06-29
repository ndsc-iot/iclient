package com.yanxin.iot.mariadb.dbop;

import com.yanxin.iot.mariadb.HibernateSessionFactory;
import com.yanxin.iot.mariadb.beans.*;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Guozhen Cheng on 2017/6/15.
 */
public class DBop {

    private static final Logger log = LoggerFactory.getLogger(DBop.class);

    // private SessionFactory sessionFactory= HibernateSessionFactory.getSessionFactory();
    //private static final Session session = sessionFactory.openSession();

    public static final List<UserPO> getUserList(){

        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        List<UserPO> users = session.createQuery("select u from UserPO u ").list();
        tx.commit();
        log.info("Query the user lists from database table user!");
        return users;
    }

    public static final UserPO getUserByName(String name){

        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        UserPO user = (UserPO)session.createQuery("from UserPO u where u.username="+name).uniqueResult();
        tx.commit();
        log.info("Query a user by name from database table user!");
        return user;
    }

    public static final List<RegionPO> getRegions(){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        List<RegionPO> regions = session.createQuery("from RegionPO r").list();
        tx.commit();
        log.info("Query the region lists from database table region!");

        return regions;
    }

    public static final RegionPO getRegionById(int id){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        RegionPO region = (RegionPO)session.createQuery("from RegionPO r where r.id="+id).uniqueResult();
        tx.commit();
        /*Hibernate.initialize(region.getSiteareaPOs());
        HibernateSessionFactory.closeSession();*/
        log.info("Query a regsion by id from database table region!");
        return region;
    }

    public static final List<SiteareaPO> getSitearea(){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        List<SiteareaPO> sites = session.createQuery("from SiteareaPO s").list();
        tx.commit();
        log.info("Query the sitearea lists from database table site area!");
        
        return sites;
    }

    public static final List<RoomPO> getrooms(){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        List<RoomPO> rooms = session.createQuery("from RoomPO r").list();
        tx.commit();
        log.info("Query the room lists from database table room!");
        return rooms;
    }

    public static final List<SensorPO> getSensors(){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        List<SensorPO> sensors = session.createQuery("from SensorPO s").list();
        tx.commit();
        log.info("Query the sensor lists from database table sensors!");
        return sensors;
    }

    public static final SensorPO getSensorById(String id){
        Session session = HibernateSessionFactory.getSession();

        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from SensorPO as s where s.id = '"+id+"'");
        //Query query = session.createQuery("from SensorPO s , RoomPO r, SensorTypePO st, SensorDataPO sd where s.id = '"+Id+"' and r.id = s.room_id and s.type_id = st.id and s.id = sd.sensor_id ");

        SensorPO sensor = (SensorPO)query.uniqueResult();
        tx.commit();
        //HibernateSessionFactory.closeSession();
        log.info("Query a sensor by ID from database table sensor!");
        return sensor;
    }

    public static final List<SensorTypePO> getSensorTypes(){
        Session session = HibernateSessionFactory.getSession();

        List<SensorTypePO> sensorTypes = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            sensorTypes = session.createQuery("from SensorTypePO st").list();
            tx.commit();
            log.info("Query the sensorType lists from database table sensor_type!");

        } catch (Exception e) {
            log.error("insert failed for some errors!");
            e.printStackTrace();
            tx.rollback();

        }
        return sensorTypes;
    }

    public static final void insertRegion(RegionPO regionPO){
        Session session = HibernateSessionFactory.getSession();

        if(null != regionPO){
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(regionPO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("insert Region successfully!");

            } catch (Exception e) {

                log.error("insert failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }else {
            log.warn("insert failed due to region's null!");
        }
    }

    public static final void insertSitearea(SiteareaPO siteareaPO){
        Session session = HibernateSessionFactory.getSession();

        if(null != siteareaPO){
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(siteareaPO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("insert sitearea successfully!");

            } catch (Exception e) {
                log.error("insert sitearea failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }else{
            log.warn("insert failed due to sitearea's null!");
        }
    }

    public static final void insertRoom(RoomPO roomPO){
        Session session = HibernateSessionFactory.getSession();

        if(null != roomPO){
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.save(roomPO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("insert room successfully!");
            } catch (HibernateException e) {
                log.error("insert sitearea failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    public static final void insertSensorType(SensorTypePO sensorTypePO){
        Session session = HibernateSessionFactory.getSession();

        if(null != sensorTypePO){
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.save(sensorTypePO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("insert sensorType successfully!");
            } catch (HibernateException e) {
                log.error("insert sensorType failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
    
    public static final void insertSensor(SensorPO sensorPO){
        Session session = HibernateSessionFactory.getSession();

        if(null != sensorPO){
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.save(sensorPO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("insert a sensor successfully!");
            } catch (HibernateException e) {
                log.error("insert sensor failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
    
    public static final void insertSensorData(SensorDataPO sensorDataPO){
        Session session = HibernateSessionFactory.getSession();

        if(null != sensorDataPO){
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.save(sensorDataPO);
                tx.commit();
                //HibernateSessionFactory.closeSession();
                log.info("[insertSensorData] insert a sensor data successfully!");
            } catch (HibernateException e) {
                log.error(" [insertSensorData] insert sensor data failed for some errors!");
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
    

    public static void main(String[] args) {
        String sensorID = "adadfasdfwe123";

        SensorPO sensor = DBop.getSensorById(sensorID);

        if(null != sensor) {
        	
        	if(null != sensor.getRoomPO()){
        		
        		log.info("roomid="+sensor.getRoomPO().getId()+"\n roomname="+sensor.getRoomPO().getName());
        	}
            log.info("Successfully get sensor by ID!");
        }

    }
}
