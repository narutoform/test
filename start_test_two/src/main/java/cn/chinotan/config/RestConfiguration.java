package cn.chinotan.config;

import cn.chinotan.exceptionUtil.ExceptionUtil;
import org.springframework.cloud.alibaba.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: test
 * @description: restTemplate配置
 * @author: xingcheng
 * @create: 2019-01-12 18:47
 **/
@Configuration
public class RestConfiguration {

    @Bean
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
