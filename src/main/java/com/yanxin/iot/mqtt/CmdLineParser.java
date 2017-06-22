package com.yanxin.iot.mqtt;

import com.yanxin.iot.property.PropertiesUtil;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.yanxin.iot.mqtt.MqttClientController.printHelp;

/**
 * Created by Guozhen Cheng on 2017/6/17.
 */
public class CmdLineParser {

    private static final Logger log = LoggerFactory.getLogger(CmdLineParser.class);

    private String[] args;

    private boolean quietMode;
    private String action;
    private String topic;
    private String message;
    private int qos;
    private String broker;
    private int port;
    private String clientId;
    private String clientIdPub;
    private String clientIdSub;
    private String subTopic;
    private String pubTopic;
    private boolean cleanSession; // Non durable subscriptions
    private boolean ssl;
    private String password;
    private String userName;
    private String protocol;

    private String url;

    private MqttClientController Client;

    public CmdLineParser(String[] args) {
        this.args = args;
        ArgsParser(args);
        startController();
    }

    public void ArgsParser(String[] args){
        // Default settings:
        quietMode 	= !PropertiesUtil.getStringByKey("mqtt_quietMode").equals("false");
        action 		= PropertiesUtil.getStringByKey("mqtt_action");
        topic 		= PropertiesUtil.getStringByKey("mqtt_topic");
        message 	= "Message from blocking Paho MQTTv3 Java client sample";
        qos 		= Integer.parseInt(PropertiesUtil.getStringByKey("mqtt_qos"));
        broker 		= PropertiesUtil.getStringByKey("mqtt_broker");
        port 		= Integer.parseInt(PropertiesUtil.getStringByKey("mqtt_port"));

        clientId 	= PropertiesUtil.getStringByKey("mqtt_client_id");
        clientIdPub 	= PropertiesUtil.getStringByKey("mqtt_client_id_pub");
        clientIdSub 	= PropertiesUtil.getStringByKey("mqtt_client_id_sub");

        subTopic	= PropertiesUtil.getStringByKey("mqtt_sub_topic");
        pubTopic 	= PropertiesUtil.getStringByKey("mqtt_pub_topic");
        cleanSession= !PropertiesUtil.getStringByKey("mqtt_clean_session").equals("false"); // Non durable subscriptions
        ssl         = !PropertiesUtil.getStringByKey("mqtt_ssl").equals("false");
        password    = PropertiesUtil.getStringByKey("mqtt_password");
        userName    = PropertiesUtil.getStringByKey("mqtt_userName");

        protocol    = PropertiesUtil.getStringByKey("mqtt_protocol");


        // Parse the arguments -
        for (int i=0; i<args.length; i++) {
            // Check this is a valid argument
            if (args[i].length() == 2 && args[i].startsWith("-")) {
                char arg = args[i].charAt(1);
                // Handle arguments that take no-value
                switch(arg) {
                    case 'h': case '?':	printHelp(); return;
                    case 'q': quietMode = true;	continue;
                }

                // Now handle the arguments that take a value and
                // ensure one is specified
                if (i == args.length -1 || args[i+1].charAt(0) == '-') {
                    log.info("Missing value for argument: "+args[i]);
                    printHelp();
                    return;
                }
                switch(arg) {
                    case 'a': action = args[++i];                 break;
                    case 't': topic = args[++i];                  break;
                    case 'm': message = args[++i];                break;
                    case 's': qos = Integer.parseInt(args[++i]);  break;
                    case 'b': broker = args[++i];                 break;
                    case 'p': port = Integer.parseInt(args[++i]); break;
                    case 'i': clientId = args[++i];				  break;
                    case 'c': cleanSession = Boolean.valueOf(args[++i]).booleanValue();  break;
                    case 'k': System.getProperties().put("javax.net.ssl.keyStore", args[++i]); break;
                    case 'w': System.getProperties().put("javax.net.ssl.keyStorePassword", args[++i]); break;
                    case 'r': System.getProperties().put("javax.net.ssl.trustStore", args[++i]); break;
                    case 'v': ssl = Boolean.valueOf(args[++i]).booleanValue(); break;
                    case 'u': userName = args[++i];               break;
                    case 'z': password = args[++i];               break;
                    default:
                        log.info("Unrecognised argument: "+args[i]);
                        printHelp();
                        return;
                }
            } else {
                log.info("Unrecognised argument: "+args[i]);
                printHelp();
                return;
            }
        }

        // Validate the provided arguments
        if (!action.equals("publish") && !action.equals("subscribe")) {
            log.info("Invalid action: "+action);
            printHelp();
            return;
        }
        if (qos < 0 || qos > 2) {
            log.info("Invalid QoS: "+qos);
            printHelp();
            return;
        }
        if (topic.equals("")) {
            // Set the default topic according to the specified action
            if (action.equals("publish")) {
                topic = pubTopic;
            } else {
                topic = subTopic;
            }
        }

        if (ssl) {
            protocol = "ssl://";
        }

        url = protocol + broker + ":" + port;

        if (clientId == null || clientId.equals("")) {
            clientId = "IOT_backend_"+action;
        }
    }

    public void startController(){

        // With a valid set of arguments, the real work of
        // driving the client API can begin
        try {
            // Create an instance of this class
            Client = new MqttClientController(url, clientId, cleanSession, quietMode,userName,password);

            Client.subscribe(topic,qos);
            // Perform the requested action
           /* if (action.equals("publish")) {
                Client.publish(topic,qos,message.getBytes());
            } else if (action.equals("subscribe")) {
                Client.subscribe(topic,qos);
            }*/
        } catch(MqttException me) {
            // Display full details of any exception that occurs
            log.info("reason "+me.getReasonCode());
            log.info("msg "+me.getMessage());
            log.info("loc "+me.getLocalizedMessage());
            log.info("cause "+me.getCause());
            log.info("excep "+me);
            me.printStackTrace();
        }
    }


    public void startPublishController(){

        // With a valid set of arguments, the real work of
        // driving the client API can begin
        try {
            // Create an instance of this class
            Client = new MqttClientController(url, clientIdPub, cleanSession, quietMode,userName,password);

            Client.publish(topic,qos,message.getBytes());

        } catch(MqttException me) {
            // Display full details of any exception that occurs
            log.info("reason "+me.getReasonCode());
            log.info("msg "+me.getMessage());
            log.info("loc "+me.getLocalizedMessage());
            log.info("cause "+me.getCause());
            log.info("excep "+me);
            me.printStackTrace();
        }
    }

    public void startSubscribeController(){

        // With a valid set of arguments, the real work of
        // driving the client API can begin
        try {
            // Create an instance of this class
            Client = new MqttClientController(url, clientId, cleanSession, quietMode,userName,password);

            // Perform the requested action
            Client.subscribe(topic,qos);
        } catch(MqttException me) {
            // Display full details of any exception that occurs
            log.info("reason "+me.getReasonCode());
            log.info("msg "+me.getMessage());
            log.info("loc "+me.getLocalizedMessage());
            log.info("cause "+me.getCause());
            log.info("excep "+me);
            me.printStackTrace();
        }
    }


    public boolean isQuietMode() {
        return quietMode;
    }

    public void setQuietMode(boolean quietMode) {
        this.quietMode = quietMode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public String getPubTopic() {
        return pubTopic;
    }

    public void setPubTopic(String pubTopic) {
        this.pubTopic = pubTopic;
    }

    public boolean isCleanSession() {
        return cleanSession;
    }

    public void setCleanSession(boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MqttClientController getClient() {
        return Client;
    }

    public void setClient(MqttClientController client) {
        Client = client;
    }
}
