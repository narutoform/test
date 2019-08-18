package cn.chinotan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: test
 * @description: 启动类
 * @author: xingcheng
 * @create: 2018-12-9 15:39
 **/
@SpringCloudApplication
@EnableEurekaClient
@EnableZuulProxy
public class StartGateway {

    public static void main(String[] args) {
        SpringApplication.run(StartGateway.class, args);
    }

}
