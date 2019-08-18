package cn.chinotan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: test
 * @description: oauth2测试类
 * @author: xingcheng
 * @create: 2018-12-01 17:43
 **/
@RestController
public class WordController {

    @RequestMapping("/")
    public String index(){

        return "index" ;
    }

    @RequestMapping("/api")
    public String api(){
        return "api" ;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}
