package com.xiaonuo.weather_report.failBack;

import com.xiaonuo.weather_report.pojo.Weatherinfo;
import com.xiaonuo.weather_report.rpc.WeatherApiRpc;
import org.springframework.stereotype.Component;

/**
 * @author ：xiaonuolen
 * @date ：Created in 2019/7/24 16:56
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class DataClientFallBack implements WeatherApiRpc {


    @Override
    public Weatherinfo getCity(String cityName) {
        //就可以直接通过在这个去返回添加
        System.out.println("熔断了");
        return null;
    }
}
