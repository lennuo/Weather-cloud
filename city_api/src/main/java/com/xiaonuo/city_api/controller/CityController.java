package com.xiaonuo.city_api.controller;


import com.xiaonuo.city_api.pojo.City;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.util.*;

@Controller
public class CityController {
    private static Map<String, List<City>> cityMap = new HashMap<>();
    private static List<String> provinceList = new ArrayList<>();

    static {
        SAXReader reader = new SAXReader();
        /*获取输入流*/
        InputStream resourceAsStream = CityController.class.getClassLoader().getResourceAsStream("static/LocList.xml");

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
    @ResponseBody
    @RequestMapping("/getCity")
    public String getCity(){
       return cityMap.get("浙江").toString();
    }

}
