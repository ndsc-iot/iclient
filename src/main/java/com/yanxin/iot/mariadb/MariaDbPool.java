package com.yanxin.iot.mariadb;

import com.yanxin.iot.property.PropertiesUtil;
import org.mariadb.jdbc.MariaDbDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guozhen Cheng on 2017/6/11.
 */
public class MariaDbPool {

    private static Logger log = LoggerFactory.getLogger(MariaDbPool.class);
    private static volatile MariaDbPool pool;
    private MariaDbDataSource ds;
    private Map<Connection, Boolean> map;

    private String mariadbHost = PropertiesUtil.getStringByKey("mariadb_host");
    private String mariadbPort = PropertiesUtil.getStringByKey("mariadb_port");
    private String mariadbName = PropertiesUtil.getStringByKey("mariadb_name");

    private String username = PropertiesUtil.getStringByKey("mariadb_username");
    private String password = PropertiesUtil.getStringByKey("mariadb_pass");
    private int initPoolSize = Integer.parseInt(PropertiesUtil.getStringByKey("mariadb_init_pool"));
    private int maxPoolSize = Integer.parseInt(PropertiesUtil.getStringByKey("mariadb_max_pool"));

    private int waitTime = Integer.parseInt(PropertiesUtil.getStringByKey("mariadb_wait_time"));


    private String url = "jdbc:maria://"+mariadbHost+":"+mariadbPort+"/"+mariadbName;


    private MariaDbPool() {
        init();

        log.info("=====MariaDB数据库连接池初始化完毕.");
    }

    public static MariaDbPool getInstance() {
        if (pool == null) {
            synchronized (MariaDbPool.class) {
                if(pool == null) {
                    pool = new MariaDbPool();
                }
            }
        }
        return pool;
    }

    private void init() {
        try {
            ds = new MariaDbDataSource();
            ds.setUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            ds.setLoginTimeout(2000);
            map = new HashMap<Connection, Boolean>();
            for (int i = 0; i < initPoolSize; i++) {
                map.put(getNewConnection(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getNewConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            for (Map.Entry<Connection, Boolean> entry : map.entrySet()) {
                if (entry.getValue()) {
                    conn = entry.getKey();
                    map.put(conn, false);
                    break;
                }
            }
            if (conn == null) {
                if (map.size() < maxPoolSize) {
                    conn = getNewConnection();
                    map.put(conn, false);
                } else {
                    wait(waitTime);
                    conn = getConnection();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void releaseConnection(Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            if(map.containsKey(conn)) {
                if (conn.isClosed()) {
                    map.remove(conn);
                } else {
                    if(!conn.getAutoCommit()) {
                        conn.setAutoCommit(true);
                    }
                    map.put(conn, true);
                }
            } else {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
