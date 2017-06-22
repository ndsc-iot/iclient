package com.yanxin.iot.mariadb.beans;

import java.util.Date;

/**
 * UserPO entity. @author MyEclipse Persistence Tools
 */

public class UserPO implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Date lastLogin;
	private Integer actor;
	private String username;
	private String password;
	private Date createdTime;

	// Constructors

	/** default constructor */
	public UserPO() {
	}

	/** full constructor */
	public UserPO(Date lastLogin, Integer actor, String username, String password, Date createdTime) {
		this.lastLogin = lastLogin;
		this.actor = actor;
		this.username = username;
		this.password = password;
		this.createdTime = createdTime;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getActor() {
		return this.actor;
	}

	public void setActor(Integer actor) {
		this.actor = actor;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}