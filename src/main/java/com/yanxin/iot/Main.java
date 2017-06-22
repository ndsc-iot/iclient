package com.yanxin.iot;

import com.yanxin.iot.mqtt.CmdLineParser;
import com.yanxin.iot.mqtt.MqttClientController;
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

        final CmdLineParser parser = new CmdLineParser(args);

        parser.startController();

        final MqttClientController client = parser.getClient();

        //client.subscribe(topicName, qos);

    }
}
