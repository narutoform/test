package cn.chinotan.feign.fallback;

import cn.chinotan.feign.EchoService;

/**
 * @program: test
 * @description: EchoServiceFallback
 * @author: xingcheng
 * @create: 2019-01-12 18:44
 **/
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String str) {
        return "echo fallback";
    }
}
