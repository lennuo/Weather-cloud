package com.xiaonuo.weather_api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="city-api")
public interface WeatherApiService {
    @GetMapping(value = "/getCity")
    public String getCity();
}
