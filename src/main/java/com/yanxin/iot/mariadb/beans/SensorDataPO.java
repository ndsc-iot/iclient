package com.yanxin.iot.mariadb.beans;

/**
 * SensorDataPO entity. @author MyEclipse Persistence Tools
 */

public class SensorDataPO implements java.io.Serializable {

	// Fields

	private Integer id;
	private SensorPO sensorPO;
	private byte[] data;

	// Constructors

	/** default constructor */
	public SensorDataPO() {
	}

	/** minimal constructor */
	public SensorDataPO(SensorPO sensorPO) {
		this.sensorPO = sensorPO;
	}

	/** full constructor */
	public SensorDataPO(SensorPO sensorPO, byte[] data) {
		this.sensorPO = sensorPO;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SensorPO getSensorPO() {
		return this.sensorPO;
	}

	public void setSensorPO(SensorPO sensorPO) {
		this.sensorPO = sensorPO;
	}

	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}