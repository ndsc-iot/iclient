/**
 * 
 */
package com.yanxin.iot.Utils;

/**
 * @author Chengguozhen
 *
 */
public class ConstantsUtil {
	
	public final static String[] PUBLISH_TOPICS = {
			"switches/v1/cmd",
			"times/v1",
	};
	
	public static String getSwitchPubTopic(String prefix, String id){
		
		return prefix+"/"+id;
	}

	public static String getTimePubTopic(int region, int site, int room, int type){
		
		return "sensors/"+region+"/"+site+"/"+room+"/";
	}
}
