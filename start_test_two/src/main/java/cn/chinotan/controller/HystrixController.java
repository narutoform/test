package cn.chinotan.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description: hystrix控制器
 * @author: xingcheng
 * @create: 2018-11-03 19:27
 **/
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("/sayHello")
    public String sayHello(String name, Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, " + name;
    }

    @HystrixCommand(fallbackMethod = "hiFallback")
    @RequestMapping("/sayHi")
    public String sayHi(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("name不能为空");
        }
        return "Good morning, " + name;
    }

    /**
     * fallback
     */
    public String helloFallback(String name, Integer time) {
        System.out.println("helloFallback: " + name);
        return "helloFallback" + name;
    }

    /**
     * fallback
     */
    public String hiFallback(String name) {
        System.out.println("hiFallback: " + name);
        return "hiFallback" + name;
    }
}

