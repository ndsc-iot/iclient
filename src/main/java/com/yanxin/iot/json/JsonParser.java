package com.yanxin.iot.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javassist.expr.NewArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Guozhen Cheng on 2017/6/18.
 */
public class JsonParser {

    private static Logger log = LoggerFactory.getLogger(JsonParser.class);
    private static Gson gson;

    public JsonParser() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }


    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
    
    public byte[] getJsonData(DevicePayload payload){
    	String command = null;
    	byte[] result = null;
    	if(null != payload){
    		command = gson.toJson(payload);
    	}
    	
    	if(null != command){
    		result = command.getBytes();
    	}
    	
    	return result;
    }
    
    public byte[] getJsonTimeData(TimePayload payload){
    	String command = null;
    	byte[] result = null;
    	if(payload != null){
    		command = gson.toJson(payload);
    		result = command.getBytes();
    	}
    	return result;
    }
    
    public DevicePayload getJsonObj(String jsonString){
    	
    	DevicePayload payload = gson.fromJson(jsonString, DevicePayload.class);
    	
    	return payload;
    }

    public DevicePayload getCommand(String deviceId, int type, int value){
    	
    	ArrayList<DeviceData> data = new ArrayList<DeviceData>();
    	DeviceData dd = new DeviceData(type, value);
    	data.add(dd);
    	
    	String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    	
    	DevicePayload payload = new DevicePayload(deviceId, data, time);
    	
    	return payload;
    }
    
    
    public static void main(String[] args) {

        JsonParser parser = new JsonParser();
        String jsonString = "{\"deviceId\":\"sdafasd\",\"data\":[{\"type\":\"1\",\"value\":\"20\"}, {\"type\":\"2\",\"value\":\"20\"}],\"time\":\"2017-06-18 16:37:34\"}";

        //log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        DevicePayload payload = parser.getGson().fromJson(jsonString,DevicePayload.class);

        log.info(payload.toString());

    }

}
