package cn.chinotan.feign;

import cn.chinotan.vo.SaySomeThing;
import cn.chinotan.config.feign.FeignConfiguration;
import cn.chinotan.feign.fallback.SayServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: test
 * @description: 说接口
 * @author: xingcheng
 * @create: 2019-01-19 18:05
 **/
@FeignClient(name = "sayService", url = "http://localhost:11111", fallback = SayServiceFallback.class, configuration = FeignConfiguration.class)
public interface SayService {

    /**
     * 说
     * @param saySomeThing
     * @return
     */
    @RequestMapping(value = "/feign/hello", method = RequestMethod.POST)
    SaySomeThing saySomeThing(@RequestBody SaySomeThing saySomeThing);
    
}
