package com.yanxin.iot.mariadb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Guozhen Cheng on 2017/6/11.
 */
public final class DBOperations {

    private static Logger log = LoggerFactory.getLogger(DBOperations.class);

    private static DBOperations opreations;

    private MariaDbPool pool = null;
    private Connection conn = null;

    private DBOperations(){
        pool = MariaDbPool.getInstance();
        conn = pool.getConnection();
    }
    public static DBOperations getInstance(){
            if(null == opreations){
                synchronized (DBOperations.class) {
                    if(null == opreations){
                        opreations = new DBOperations();
                    }
                }
            }
            return opreations;
    }

    public boolean insertDB(String sql){

        return false;
    }

    public ResultSet queryDB(String sql){
        ResultSet resultSet = null;

        return resultSet;
    }


}
