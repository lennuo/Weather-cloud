package com.xiaonuo.weather_report.job;

import com.xiaonuo.weather_report.pojo.City;
import com.xiaonuo.weather_report.pojo.Weatherinfo;
import com.xiaonuo.weather_report.rpc.WeatherApiRpc;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.InputStream;
import java.util.*;

public class WeatherQuartzJob extends QuartzJobBean {

    private static Map<String, List<City>> cityMap = new HashMap<>();
    private static List<String> provinceList = new ArrayList<>();

    @Autowired
    private WeatherApiRpc weatherGet1;

    static {
        SAXReader reader = new SAXReader();
        /*获取输入流*/
        InputStream resourceAsStream = WeatherQuartzJob.class.getClassLoader().getResourceAsStream("static/LocList.xml");

        try {
            //读取
            Document read = reader.read(resourceAsStream);

            Element rootElement = read.getRootElement();

            Iterator<Element> countryIt = rootElement.elementIterator();

            //获取中国
            Element country = countryIt.next();
            //Attribute state = next.attribute("Name");

            //获取省份
            Iterator<Element> provinceIt = country.elementIterator();
            while (provinceIt.hasNext()){

                List<City> cityList = new ArrayList<>();

                Element province = provinceIt.next();

                Attribute provinceName = province.attribute("Name");

                System.out.println(provinceName.getValue());
                provinceList.add(provinceName.getValue());
                Iterator<Element> cityIt = province.elementIterator();
                while (cityIt.hasNext()){
                    City city = new City();

                    //设置省
                    city.setProvince(provinceName.getValue());


                    Element cityElement = cityIt.next();
                    Attribute cityName = cityElement.attribute("Name");
                    System.out.println(cityName.getValue());
                    //设置市级城市
                    city.setCityName(cityName.getValue());



                    Iterator<Element> countyElement = cityElement.elementIterator();
                    List<String> countyList = new ArrayList<>();
                    while(countyElement.hasNext()){
                        Element county = countyElement.next();

                        Attribute countyName = county.attribute("Name");
                        countyList.add(countyName.getValue());
                    }
                    city.setCountyList(countyList);

                    cityList.add(city);
                }
                cityMap.put(provinceName.getValue(),cityList);

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    private final static Logger logger = LoggerFactory.getLogger(WeatherQuartzJob.class);

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for (String province : provinceList) {
            List<City> cityList = cityMap.get(province);
            for (City city : cityList) {
                List<String> countyList = city.getCountyList();
                for (String county : countyList) {
                    Weatherinfo dataByCityName = weatherGet1.getCity(county);
                    System.out.println(dataByCityName);
                }
            }
        }
   }
}
