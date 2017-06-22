package com.yanxin.iot.mariadb.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SensorTypePO entity. @author MyEclipse Persistence Tools
 */

public class SensorTypePO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private Date createdTime;
	private Set sensorPOs = new HashSet(0);

	// Constructors

	/** default constructor */
	public SensorTypePO() {
	}

	/** full constructor */
	public SensorTypePO(String type, Date createdTime, Set sensorPOs) {
		this.type = type;
		this.createdTime = createdTime;
		this.sensorPOs = sensorPOs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Set getSensorPOs() {
		return this.sensorPOs;
	}

	public void setSensorPOs(Set sensorPOs) {
		this.sensorPOs = sensorPOs;
	}

}