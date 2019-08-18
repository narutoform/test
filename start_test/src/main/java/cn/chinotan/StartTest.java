package cn.chinotan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

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
//@EnableRabbit
//@EnableEurekaClient
public class StartTest {

    public static void main(String[] args) {
        SpringApplication.run(StartTest.class, args);
    }
    
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
