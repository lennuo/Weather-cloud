package com.xiaonuo.weather_api.pojo;

import java.io.Serializable;

/**
 * 未来天气
 *
 * @author: Lucifer
 * @create: 2018-09-23 23:10
 * @description:
 **/
public class Forecast implements Serializable {

 /*   "forecast":[{
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
    }]*/

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", fengli='" + fengli + '\'' +
                ", low='" + low + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}