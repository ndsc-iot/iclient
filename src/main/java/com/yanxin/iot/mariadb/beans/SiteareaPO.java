package com.yanxin.iot.mariadb.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SiteareaPO entity. @author MyEclipse Persistence Tools
 */

public class SiteareaPO implements java.io.Serializable {

	// Fields

	private Integer id;
	private RegionPO regionPO;
	private String name;
	private Date createdTime;
	private Set roomPOs = new HashSet(0);

	// Constructors

	/** default constructor */
	public SiteareaPO() {
	}

	/** full constructor */
	public SiteareaPO(RegionPO regionPO, String name, Date createdTime, Set roomPOs) {
		this.regionPO = regionPO;
		this.name = name;
		this.createdTime = createdTime;
		this.roomPOs = roomPOs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegionPO getRegionPO() {
		return this.regionPO;
	}

	public void setRegionPO(RegionPO regionPO) {
		this.regionPO = regionPO;
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

	public Set getRoomPOs() {
		return this.roomPOs;
	}

	public void setRoomPOs(Set roomPOs) {
		this.roomPOs = roomPOs;
	}

}