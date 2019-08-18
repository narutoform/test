package cn.chinotan.controller;

import cn.chinotan.feign.EchoService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: test
 * @description: 最简单的使用 Sentinel 的例子
 * @author: xingcheng
 * @create: 2019-01-12 18:01
 **/
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    EchoService echoService;
    
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello", fallback = "helloFallback")
    public String hello() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Sentinel";
    }

    public String helloFallback() {
        return "helloFallback";
    }

    @GetMapping(value = "/echoFeign/{str}")
    public String echoFeign(@PathVariable("str") String str) {
        System.out.println("echoFeign");
        return echoService.echo(str);
    }

    @GetMapping(value = "/echoRestTemplate/{str}")
    public String echoRestTemplate(@PathVariable("str") String str) {
        System.out.println("echoRestTemplate");
        return restTemplate.getForObject("http://localhost:11111/sentinel/show/echo/" + str, String.class);
    }

    @GetMapping(value = "/show/echo/{str}")
    public String echo(@PathVariable("str") String str) {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("show_echo");
        return "show_echo: " + str;
    }
}
