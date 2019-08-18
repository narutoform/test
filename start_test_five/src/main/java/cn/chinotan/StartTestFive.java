package cn.chinotan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: test
 * @description: 启动类
 * @author: xingcheng
 * @create: 2018-12-9 15:39
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"cn.chinotan"})
@ServletComponentScan
@EnableEurekaClient
public class StartTestFive {

    public static void main(String[] args) {
        SpringApplication.run(StartTestFive.class, args);
    }

}
