package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "room", schema = "iotdb") //, catalog = "")
public class RoomPO {
    private Integer id;
    private String name;
    private Integer siteId;
    private Timestamp createdTime;
    private SiteareaPO siteareaBySiteId;
    private Collection<SensorPO> sensorsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "site_id")
    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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

        RoomPO roomPO = (RoomPO) o;

        if (id != null ? !id.equals(roomPO.id) : roomPO.id != null) return false;
        if (name != null ? !name.equals(roomPO.name) : roomPO.name != null) return false;
        if (siteId != null ? !siteId.equals(roomPO.siteId) : roomPO.siteId != null) return false;
        if (createdTime != null ? !createdTime.equals(roomPO.createdTime) : roomPO.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    public SiteareaPO getSiteareaBySiteId() {
        return siteareaBySiteId;
    }

    public void setSiteareaBySiteId(SiteareaPO siteareaBySiteId) {
        this.siteareaBySiteId = siteareaBySiteId;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<SensorPO> getSensorsById() {
        return sensorsById;
    }

    public void setSensorsById(Collection<SensorPO> sensorsById) {
        this.sensorsById = sensorsById;
    }
}
