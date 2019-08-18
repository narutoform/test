package cn.chinotan.config.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import static feign.FeignException.errorStatus;

/**
 * @program: test
 * @description: feign调用异常统一处理
 * @author: xingcheng
 * @create: 2019-01-19 19:47
 **/
@Configuration
public class MyErrorDecoder implements ErrorDecoder {
    
    Logger logger = LoggerFactory.getLogger(MyErrorDecoder.class);
    
    @Override
    public Exception decode(String methodKey, Response response) {
        FeignException exception = errorStatus(methodKey, response);
        // 报警
        logger.error("methodKey: {}, reason is {}", methodKey, response.toString());
        return exception;
    }
    
}
