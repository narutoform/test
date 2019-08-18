package cn.chinotan.controller;

import cn.chinotan.vo.Animal;
import cn.chinotan.vo.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description: test类
 * @author: xingcheng
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    Animal animal;

    @Autowired
    Dog dog;

    @GetMapping("/aopRun")
    public String aopRun() {
        animal.run("狗窝");
        System.out.println("dog代理为：" + animal.getClass());

        return "ok";
    }

    @GetMapping("/aopRunToEat")
    public String aopRunToEat() {
        animal.runToEat("狗粮");
        System.out.println("dog代理为：" + animal.getClass());

        return "ok";
    }

}
