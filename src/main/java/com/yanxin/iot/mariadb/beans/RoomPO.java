package com.yanxin.iot.mariadb.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RoomPO entity. @author MyEclipse Persistence Tools
 */

public class RoomPO implements java.io.Serializable {

	// Fields

	private Integer id;
	private SiteareaPO siteareaPO;
	private String name;
	private Date createdTime;
	private Set sensorPOs = new HashSet(0);

	// Constructors

	/** default constructor */
	public RoomPO() {
	}

	/** minimal constructor */
	public RoomPO(SiteareaPO siteareaPO) {
		this.siteareaPO = siteareaPO;
	}

	/** full constructor */
	public RoomPO(SiteareaPO siteareaPO, String name, Date createdTime, Set sensorPOs) {
		this.siteareaPO = siteareaPO;
		this.name = name;
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

	public SiteareaPO getSiteareaPO() {
		return this.siteareaPO;
	}

	public void setSiteareaPO(SiteareaPO siteareaPO) {
		this.siteareaPO = siteareaPO;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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