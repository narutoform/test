package cn.chinotan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: test
 * @description: 启动类
 * @author: xingcheng
 * @create: 2018-12-9 15:39
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"cn.chinotan"})
@ServletComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class StartOnlyTest {

    public static void main(String[] args) {
        SpringApplication.run(StartOnlyTest.class, args);
    }

}
