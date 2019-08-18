package cn.chinotan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@ServletComponentScan
public class StartConfigServerEureka {

    public static void main(String[] args) {
        SpringApplication.run(StartConfigServerEureka.class, args);
    }

}
