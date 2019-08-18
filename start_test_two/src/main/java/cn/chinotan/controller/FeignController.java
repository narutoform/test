package cn.chinotan.controller;

import cn.chinotan.vo.SaySomeThing;
import cn.chinotan.feign.SayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description: 最简单的使用 Sentinel 的例子
 * @author: xingcheng
 * @create: 2019-01-20 18:01
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    SayService sayService;

    @PostMapping(value = "/hello")
    public SaySomeThing hello(@RequestBody SaySomeThing saySomeThing) {
        throw new RuntimeException("我是异常");
//        return saySomeThing;
    }

    @PostMapping(value = "/say")
    public SaySomeThing echoFeign(@RequestBody SaySomeThing saySomeThing) {
        return sayService.saySomeThing(saySomeThing);
    }
}
