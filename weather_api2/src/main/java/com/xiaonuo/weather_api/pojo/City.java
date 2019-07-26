package com.xiaonuo.weather_api.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/*
* 城市列表
*
* */
@Repository
public class City implements Serializable {

    private String province;
    private String cityName;
    private List<String> countyList;

    public List<String> getCountyList() {
        return countyList;
    }

    public void setCountyList(List<String> countyList) {
        this.countyList = countyList;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "province='" + province + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countyList=" + countyList +
                '}';
    }
}
