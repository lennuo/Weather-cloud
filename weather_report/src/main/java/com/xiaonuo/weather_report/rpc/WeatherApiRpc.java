package com.xiaonuo.weather_report.rpc;

import com.xiaonuo.weather_report.pojo.Weatherinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zuul")
public interface WeatherApiRpc {
    @GetMapping(value = "/weather/city/{cityName}")
    public Weatherinfo getCity(@PathVariable String cityName);
}
