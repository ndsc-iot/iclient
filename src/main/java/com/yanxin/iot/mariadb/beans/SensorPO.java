package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "sensor", schema = "iotdb") //, catalog = "")
public class SensorPO {
    private String id;
    private Integer typeId;
    private Timestamp createdTime;
    private Integer roomId;
    private RoomPO roomByRoomId;
    private SensorTypePO sensorTypeByTypeId;
    private Collection<SensorDataPO> sensorDataById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorPO sensorPO = (SensorPO) o;

        if (id != null ? !id.equals(sensorPO.id) : sensorPO.id != null) return false;
        if (typeId != null ? !typeId.equals(sensorPO.typeId) : sensorPO.typeId != null) return false;
        if (createdTime != null ? !createdTime.equals(sensorPO.createdTime) : sensorPO.createdTime != null)
            return false;
        if (roomId != null ? !roomId.equals(sensorPO.roomId) : sensorPO.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    public RoomPO getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomPO roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public SensorTypePO getSensorTypeByTypeId() {
        return sensorTypeByTypeId;
    }

    public void setSensorTypeByTypeId(SensorTypePO sensorTypeByTypeId) {
        this.sensorTypeByTypeId = sensorTypeByTypeId;
    }

    @OneToMany(mappedBy = "sensorBySensorId")
    public Collection<SensorDataPO> getSensorDataById() {
        return sensorDataById;
    }

    public void setSensorDataById(Collection<SensorDataPO> sensorDataById) {
        this.sensorDataById = sensorDataById;
    }
}
