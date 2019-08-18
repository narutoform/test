package cn.chinotan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: test
 * @description: 启动类
 * @author: xingcheng
 * @create: 2018-08-12 15:39
 **/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"cn.chinotan"})
@ServletComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableFeignClients
public class StartTestTwo {

    public static void main(String[] args) {
        SpringApplication.run(StartTestTwo.class, args);
    }

}
