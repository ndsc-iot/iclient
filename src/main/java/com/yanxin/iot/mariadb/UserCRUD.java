package com.yanxin.iot.mariadb;

import com.yanxin.iot.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Guozhen Cheng on 2017/6/11.
 */
public class UserCRUD {

    private static final Logger log = LoggerFactory.getLogger(UserCRUD.class);

    private static final Session session = HibernateUtil.getSessionFactory().openSession();

    public UserCRUD() {
    }

    /*public static void setUser(User user){
        session.beginTransaction();
        if(null != user){
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public static final List getUserList(){
        String hql = "FROM User";
        session.beginTransaction();
        Query query = session.createQuery(hql);
        List results = query.list();

        return results;
    }

    public static final List getUserByName(String username){
        String hql = "FROM User AS U WHERE U.username = "+ username;
        session.beginTransaction();
        Query query = session.createQuery(hql);
        List results = query.list();

        return results;

    }*/

    // test code
/*    public static void main(String[] args) {
        String hql = "FROM User";
        session.beginTransaction();
        Query query = session.createQuery(hql);
        log.info("成功查询到USER表格");
        List<User> results = query.list();
        if(null == results) {
            log.info("得到0个用户");
        }else {
            log.info("得到的用户数为"+results.size());
        }

    }*/


}
