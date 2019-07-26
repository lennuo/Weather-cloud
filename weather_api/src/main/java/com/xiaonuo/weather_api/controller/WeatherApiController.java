package com.xiaonuo.weather_api.controller;


import com.xiaonuo.weather_api.pojo.Weatherinfo;
import com.xiaonuo.weather_api.service.WeatherApiService;
import com.xiaonuo.weather_api.service.WeatherGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherApiController {

    @Autowired
    private WeatherGet weatherGet;
    @Autowired
    private WeatherApiService weatherApiService;
    @ResponseBody
    @RequestMapping(value = "/city/{cityName}")
    public Weatherinfo getWeatherByCity(@PathVariable String cityName) {
        System.out.println("模块1");
        return weatherGet.getDataByCityName(cityName);
    }

}
