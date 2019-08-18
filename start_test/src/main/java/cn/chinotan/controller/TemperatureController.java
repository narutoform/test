package cn.chinotan.controller;

import cn.chinotan.dto.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @program: test
 * @description: 温度服务
 * @author: xingcheng
 * @create: 2018-11-17 19:45
 **/
@RestController
public class TemperatureController {

    @GetMapping("/temperature/{city}")
    public Temperature getAverageTemperature(@PathVariable("city") String city) {
        Temperature temperature = new Temperature();
        temperature.setTemperature((double) (new Random().nextInt(20) + 30));
        temperature.setScale("Celsius");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        return temperature;
    }

}
