package com.xiaonuo.weather_report.contorller;

import com.alibaba.fastjson.JSONObject;
import com.xiaonuo.weather_report.pojo.Weatherinfo;
import com.xiaonuo.weather_report.rpc.WeatherApiRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {

    @Autowired
    private WeatherApiRpc weatherGet1;

    @ResponseBody
    @RequestMapping(value = "/queryWeatherByCity")
    public String get(@RequestBody JSONObject city){
        //int a = 1/0;

        System.out.println(city.get("city"));

        return weatherGet1.getCity((String) city.get("city")).toString();
    }
}
