package com.yanxin.iot.json;

/**
 * Created by Guozhen Cheng on 2017/6/18.
 */
public class DeviceData {
    private int type;
    private int value;
    private String status;

    public DeviceData(int type, int value, String status) {
        this.type = type;
        this.value = value;
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("type="+getType()+"\n");
        sb.append("value="+getValue()+"\n");
        sb.append("status="+getStatus()+"\n");

        return sb.toString();
    }
}
