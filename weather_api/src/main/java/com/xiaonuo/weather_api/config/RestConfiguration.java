package com.xiaonuo.weather_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    public RestTemplate restTemplate(){

        RestTemplate build = builder.build();
        return build;

    }

}
