package cn.chinotan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description: zuul测试控制器
 * @author: xingcheng
 * @create: 2018-12-08 18:09
 **/
@RestController
@RequestMapping("/five")
public class ZuulTestFiveController {
    
    @GetMapping("/hello/{name}")
    public String ZuulTestFive(@PathVariable("name") String name) {
        return "hello " + name + "  this is ZuulTestFive";
    }
    
}
