package cn.chinotan.feign;

import cn.chinotan.config.feign.FeignConfiguration;
import cn.chinotan.feign.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: test
 * @description: FeignClient 接口
 * @author: xingcheng
 * @create: 2019-01-12 18:43
 **/
@FeignClient(name = "echo-provider", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class, url = "http://localhost:11111")
public interface EchoService {
    @RequestMapping(value = "/sentinel/show/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable("str") String str);
}
