package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "sitearea", schema = "iotdb") //, catalog = "")
public class SiteareaPO {
    private Integer id;
    private Integer name;
    private Integer regionId;
    private Timestamp createdTime;
    private Collection<RoomPO> roomsById;
    private RegionPO regionByRegionId;

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
    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    @Basic
    @Column(name = "region_id")
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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

        SiteareaPO that = (SiteareaPO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "siteareaBySiteId")
    public Collection<RoomPO> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<RoomPO> roomsById) {
        this.roomsById = roomsById;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    public RegionPO getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(RegionPO regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }
}
