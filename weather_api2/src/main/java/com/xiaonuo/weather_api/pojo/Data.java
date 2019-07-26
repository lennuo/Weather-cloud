package com.xiaonuo.weather_api.pojo;

import java.io.Serializable;

public class Data implements Serializable {
    private Weatherinfo data;
    private String status;
    private String desc;

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Weatherinfo getData() {
        return data;
    }

    public void setData(Weatherinfo data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
