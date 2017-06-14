package com.yanxin.iot.mariadb.beans;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Guozhen Cheng on 2017/6/14.
 */
@Entity
@Table(name = "sensor_data", schema = "iotdb") //, catalog = "")
public class SensorDataPO {
    private Integer id;
    private byte[] data;
    private SensorPO sensorBySensorId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorDataPO that = (SensorDataPO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!Arrays.equals(data, that.data)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = false)
    public SensorPO getSensorBySensorId() {
        return sensorBySensorId;
    }

    public void setSensorBySensorId(SensorPO sensorBySensorId) {
        this.sensorBySensorId = sensorBySensorId;
    }
}
