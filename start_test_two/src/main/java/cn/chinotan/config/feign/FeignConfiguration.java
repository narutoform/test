package cn.chinotan.config.feign;

import cn.chinotan.feign.fallback.EchoServiceFallback;
import cn.chinotan.feign.fallback.SayServiceFallback;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: test
 * @description: FeignConfiguration
 * @author: xingcheng
 * @create: 2019-01-12 18:44
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

    @Bean
    public SayServiceFallback sayServiceFallback() {
        return new SayServiceFallback();
    }
    
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
    