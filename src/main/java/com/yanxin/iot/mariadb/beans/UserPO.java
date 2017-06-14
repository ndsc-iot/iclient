package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "user", schema = "iotdb") //, catalog = "")
public class UserPO {
    private Integer userId;
    private Date lastLogin;
    private Integer actor;
    private String username;
    private String password;
    private Timestamp createdTime;

    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "last_login")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "actor")
    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPO userPO = (UserPO) o;

        if (userId != null ? !userId.equals(userPO.userId) : userPO.userId != null) return false;
        if (lastLogin != null ? !lastLogin.equals(userPO.lastLogin) : userPO.lastLogin != null) return false;
        if (actor != null ? !actor.equals(userPO.actor) : userPO.actor != null) return false;
        if (username != null ? !username.equals(userPO.username) : userPO.username != null) return false;
        if (password != null ? !password.equals(userPO.password) : userPO.password != null) return false;
        if (createdTime != null ? !createdTime.equals(userPO.createdTime) : userPO.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }
}
