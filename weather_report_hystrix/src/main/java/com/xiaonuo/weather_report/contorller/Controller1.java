package com.xiaonuo.weather_report.contorller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.xiaonuo.weather_report.pojo.Weatherinfo;
import com.xiaonuo.weather_report.rpc.WeatherApiRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller1 {

    @Autowired
    private WeatherApiRpc weatherApiRpc;


    //@HystrixCommand(fallbackMethod = "defaultCities")
    @ResponseBody
    @RequestMapping(value = "/queryWeatherByCity")
    public Weatherinfo get(@RequestBody JSONObject info){
        //int a = 1/0;
//        System.out.println(city.get("city"));
        Weatherinfo city = weatherApiRpc.getCity((String) info.get("city"));
        return city;
    }

    public String defaultCities(){
        return "City Data Server is down!";
    }
}
