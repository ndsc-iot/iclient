package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "region", schema = "iotdb") //, catalog = "")
public class RegionPO {
    private Integer id;
    private String name;
    private Timestamp createdTime;
    private Collection<SiteareaPO> siteareasById;

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

        RegionPO regionPO = (RegionPO) o;

        if (id != null ? !id.equals(regionPO.id) : regionPO.id != null) return false;
        if (name != null ? !name.equals(regionPO.name) : regionPO.name != null) return false;
        if (createdTime != null ? !createdTime.equals(regionPO.createdTime) : regionPO.createdTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegionId")
    public Collection<SiteareaPO> getSiteareasById() {
        return siteareasById;
    }

    public void setSiteareasById(Collection<SiteareaPO> siteareasById) {
        this.siteareasById = siteareasById;
    }
}
