package com.yanxin.iot.mariadb.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SensorPO entity. @author MyEclipse Persistence Tools
 */

public class SensorPO implements java.io.Serializable {

	// Fields

	private String id;
	private RoomPO roomPO;
	private SensorTypePO sensorTypePO;
	private Date createdTime;
	private Set sensorDataPOs = new HashSet(0);

	// Constructors

	/** default constructor */
	public SensorPO() {
	}

	/** minimal constructor */
	public SensorPO(String id, RoomPO roomPO, SensorTypePO sensorTypePO) {
		this.id = id;
		this.roomPO = roomPO;
		this.sensorTypePO = sensorTypePO;
	}

	/** full constructor */
	public SensorPO(String id, RoomPO roomPO, SensorTypePO sensorTypePO, Date createdTime, Set sensorDataPOs) {
		this.id = id;
		this.roomPO = roomPO;
		this.sensorTypePO = sensorTypePO;
		this.createdTime = createdTime;
		this.sensorDataPOs = sensorDataPOs;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoomPO getRoomPO() {
		return this.roomPO;
	}

	public void setRoomPO(RoomPO roomPO) {
		this.roomPO = roomPO;
	}

	public SensorTypePO getSensorTypePO() {
		return this.sensorTypePO;
	}

	public void setSensorTypePO(SensorTypePO sensorTypePO) {
		this.sensorTypePO = sensorTypePO;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Set getSensorDataPOs() {
		return this.sensorDataPOs;
	}

	public void setSensorDataPOs(Set sensorDataPOs) {
		this.sensorDataPOs = sensorDataPOs;
	}

}