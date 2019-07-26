package com.xiaonuo.weather_api.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaonuo.weather_api.service.WeatherGet;
import com.xiaonuo.weather_api.pojo.Weatherinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


@Service
public class WeatherGetImpl implements WeatherGet {
    private static final long TIMEOUT = 10L;
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private final static Logger logger = LoggerFactory.getLogger(WeatherGet.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Weatherinfo getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.getWeatherResponse(uri);
    }


    @Override
    public Weatherinfo getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.getWeatherResponse(uri);
    }


    private Weatherinfo getWeatherResponse(String uri) {
        ObjectMapper objectMapper = new ObjectMapper();
        Weatherinfo resp = null;
        String strBody = null;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //先去去查询redis
        if(stringRedisTemplate.hasKey(uri)){
            strBody = ops.get(uri);
            logger.info("redis has data");
        }
        else{
            //再去查询接口
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
                strBody = strBody.substring(8,strBody.length()-27);
                System.out.println(strBody);
            }
            ops.set(uri,strBody,TIMEOUT, TimeUnit.SECONDS);
            logger.info("redis don't has data");
        }

        try {
            resp = objectMapper.readValue(strBody, Weatherinfo.class);
        } catch (Exception e) {
            logger.error("Error:" + e.getMessage());
        }
        return resp;

    }


}