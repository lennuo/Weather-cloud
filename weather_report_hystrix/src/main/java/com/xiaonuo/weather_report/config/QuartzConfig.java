package com.xiaonuo.weather_report.config;

import com.xiaonuo.weather_report.job.WeatherQuartzJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    //定义特定的
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherQuartzJob.class).withDescription("weatherQuartzJob")
                .storeDurably().build();//构造jobDetail
    }
    //触发详情
    @Bean
    public Trigger weatherDataSyncJobTigger(){

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withDescription("weatherDataSyncJobTigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0-23/1 * * ?")).build();
    }
}
