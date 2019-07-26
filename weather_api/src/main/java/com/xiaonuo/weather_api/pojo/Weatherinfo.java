package com.xiaonuo.weather_api.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Lucifer
 * @create: 2018-09-23 23:00
 * @description: 天气信息
 **/
public class Weatherinfo implements Serializable {

/*
             http://wthrcdn.etouch.cn/weather_mini?city=北京
 {
        "data":{
        "yesterday":{
            "date":"22日星期六", "high":"高温 24℃", "fx":"西北风", "low":"低温 13℃", "fl":"<![CDATA[3-4级]]>", "type":"晴"
        },"city":"北京", "aqi":"35", "forecast":[{
            "date":"23日星期天", "high":"高温 24℃", "fengli":"<![CDATA[4-5级]]>", "low":"低温 12℃", "fengxiang":"北风", "type":"晴"
        },{
            "date":"24日星期一", "high":"高温 23℃", "fengli":"<![CDATA[<3级]]>", "low":"低温 11℃", "fengxiang":"无持续风向", "type":
            "晴"
        },{
            "date":"25日星期二", "high":"高温 23℃", "fengli":"<![CDATA[<3级]]>", "low":"低温 13℃", "fengxiang":"南风", "type":"多云"
        },{
            "date":"26日星期三", "high":"高温 22℃", "fengli":"<![CDATA[<3级]]>", "low":"低温 14℃", "fengxiang":"南风", "type":"多云"
        },{
            "date":"27日星期四", "high":"高温 22℃", "fengli":"<![CDATA[3-4级]]>", "low":"低温 14℃", "fengxiang":"南风", "type":"阴"
        }],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。", "wendu":"14"
    },"status":1000, "desc":"OK"
    }*/

    private String city;
    private Yesterday yesterday;
    private String aqi;
    private String ganmao;
    private String wendu;
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weatherinfo{" +
                "city='" + city + '\'' +
                ", yesterday=" + yesterday +
                ", aqi='" + aqi + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", forecast=" + forecast +
                '}';
    }
}