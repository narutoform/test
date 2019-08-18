package cn.chinotan.controller;

import cn.chinotan.dto.Forecast;
import cn.chinotan.dto.Location;
import cn.chinotan.dto.Temperature;
import cn.chinotan.dto.response.ServiceResponse;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.internal.util.InternalObservableUtils;
import rx.schedulers.Schedulers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: test
 * @description: 天气预报
 * @author: xingcheng
 * @create: 2018-11-17 19:47
 **/
@RestController
public class ForecastController {

    @Autowired
    RestTemplate restTemplate;

    private final static String SERVER_ADDRESS = "http://localhost:9000";

    @GetMapping("/v1/forecast")
    public ServiceResponse getLocationsWithTemperatureV1() {
        long startTime = System.currentTimeMillis();

        ServiceResponse response = new ServiceResponse();
        List<Location> locations = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/location"), HttpMethod.GET,
                HttpEntity.EMPTY, new ParameterizedTypeReference<List<Location>>() {
                }).getBody();
        locations.forEach(location -> {
            Temperature temperature = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/temperature/", location.getName()),
                    HttpMethod.GET, HttpEntity.EMPTY, Temperature.class).getBody();
            response.getForecasts().add(new Forecast(location).setTemperature(temperature));
        });

        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);
        return response;
    }

    @GetMapping("/v2/forecast")
    public ServiceResponse getLocationsWithTemperatureV2() {
        long startTime = System.currentTimeMillis();

        ServiceResponse response = new ServiceResponse();
        List<Location> locations = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/location"), HttpMethod.GET,
                HttpEntity.EMPTY, new ParameterizedTypeReference<List<Location>>() {
                }).getBody();
        List<Forecast> collect = locations.parallelStream().map(location -> {
            Temperature temperature = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/temperature/", location.getName()),
                    HttpMethod.GET, HttpEntity.EMPTY, Temperature.class).getBody();
            return new Forecast(location).setTemperature(temperature);
        }).collect(Collectors.toList());
        long sortStart = System.currentTimeMillis();
        List<Forecast> collectResponse = collect.parallelStream().sorted().collect(Collectors.toList());
        long sortEnd = System.currentTimeMillis();
        System.out.println("排序花费时间：" + (sortEnd - sortStart));
        response.setForecasts(collectResponse);
        
        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);
        return response;
    }

    @GetMapping("/v3/forecast")
    public ServiceResponse getLocationsWithTemperatureV3() {
        long startTime = System.currentTimeMillis();

        ServiceResponse response = new ServiceResponse();
        List<Location> locations = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/location"), HttpMethod.GET,
                HttpEntity.EMPTY, new ParameterizedTypeReference<List<Location>>() {
                }).getBody();
        locations.parallelStream().forEachOrdered(location -> {
            Temperature temperature = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/temperature/", location.getName()),
                    HttpMethod.GET, HttpEntity.EMPTY, Temperature.class).getBody();
            response.getForecasts().add(new Forecast(location).setTemperature(temperature));
        });

        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);
        return response;
    }

    @GetMapping("/v4/forecast")
    public ServiceResponse getLocationsWithTemperatureV4() {
        long startTime = System.currentTimeMillis();

        ServiceResponse response = new ServiceResponse();
        List<Location> locations = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/location"), HttpMethod.GET,
                HttpEntity.EMPTY, new ParameterizedTypeReference<List<Location>>() {
                }).getBody();
        Observable.from(locations).flatMap(location -> Observable.just(location)
                .subscribeOn(Schedulers.computation()))
                .subscribe(location -> {
            Temperature temperature = restTemplate.exchange(StringUtils.join(SERVER_ADDRESS, "/temperature/", location.getName()),
                    HttpMethod.GET, HttpEntity.EMPTY, Temperature.class).getBody();
            response.getForecasts().add(new Forecast(location).setTemperature(temperature));
        });

        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);
        return response;
    }

}
