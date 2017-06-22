package com.yanxin.iot.mariadb.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RegionPO entity. @author MyEclipse Persistence Tools
 */

public class RegionPO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Date createdTime;
	private Set siteareaPOs = new HashSet(0);

	// Constructors

	/** default constructor */
	public RegionPO() {
	}

	/** full constructor */
	public RegionPO(String name, Date createdTime, Set siteareaPOs) {
		this.name = name;
		this.createdTime = createdTime;
		this.siteareaPOs = siteareaPOs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set getSiteareaPOs() {
		return this.siteareaPOs;
	}

	public void setSiteareaPOs(Set siteareaPOs) {
		this.siteareaPOs = siteareaPOs;
	}

}