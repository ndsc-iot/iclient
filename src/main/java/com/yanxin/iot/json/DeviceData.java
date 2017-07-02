package com.yanxin.iot.json;

/**
 * Created by Guozhen Cheng on 2017/6/18.
 */
public class DeviceData {
    private int type;
    private int value;

    public DeviceData(int type, int value) {
        this.type = type;
        this.value = value;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("(type="+getType()+" ");
        sb.append("value="+getValue()+"),");

        return sb.toString();
    }
}
