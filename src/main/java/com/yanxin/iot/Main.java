package com.yanxin.iot;

import com.yanxin.iot.property.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Guozhen Cheng on 2017/6/11.
 */
public class Main
{
    private static Logger  log = LoggerFactory.getLogger(Main.class);

    public static void main( String[] args )
    {
        String mariadb_host = PropertiesUtil.getStringByKey("mariadb_host");
        log.info("读取到mariadb_host="+mariadb_host);
    }
}
