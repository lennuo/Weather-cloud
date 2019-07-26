package com.xiaonuo.weather_api.service;

import com.xiaonuo.weather_api.pojo.Weatherinfo;

public interface WeatherGet {

    Weatherinfo getDataByCityId(String id);
    Weatherinfo getDataByCityName(String id);

}
