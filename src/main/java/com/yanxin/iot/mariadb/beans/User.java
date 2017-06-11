package com.yanxin.iot.mariadb.beans;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/11.
 */
public class User implements java.io.Serializable {

    private int userId;
    private Date lastLogin;
    private int actor;

    private String username;
    private String password;

    private Date CreatedDate;

    public User(){
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, Date lastLogin, int actor, String username, String password, Date createdDate) {
        this.userId = userId;
        this.lastLogin = lastLogin;
        this.actor = actor;
        this.username = username;
        this.password = password;
        CreatedDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }
}
