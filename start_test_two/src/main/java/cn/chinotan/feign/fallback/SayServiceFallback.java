package cn.chinotan.feign.fallback;

import cn.chinotan.vo.SaySomeThing;
import cn.chinotan.feign.SayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: test
 * @description: say快速失败
 * @author: xingcheng
 * @create: 2019-01-19 18:18
 **/
public class SayServiceFallback implements SayService {
    
    Logger logger = LoggerFactory.getLogger(SayServiceFallback.class);
    
    @Override
    public SaySomeThing saySomeThing(SaySomeThing saySomeThing) {
        SaySomeThing saySomeThingFail = new SaySomeThing();
        saySomeThingFail.setName("错误");
        saySomeThingFail.setWords("错误的话");
        logger.error("调用失败");
        return saySomeThingFail;
    }
}
