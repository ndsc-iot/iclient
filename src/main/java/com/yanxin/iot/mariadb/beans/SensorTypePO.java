package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "sensor_type", schema = "iotdb") //, catalog = "")
public class SensorTypePO {
    private Integer id;
    private String type;
    private Timestamp createdTime;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        SensorTypePO that = (SensorTypePO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sensorTypeByTypeId")
    public Collection<SensorPO> getSensorsById() {
        return sensorsById;
    }

    public void setSensorsById(Collection<SensorPO> sensorsById) {
        this.sensorsById = sensorsById;
    }
}
