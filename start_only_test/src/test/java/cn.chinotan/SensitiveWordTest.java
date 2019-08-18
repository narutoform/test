package cn.chinotan;

import cn.chinotan.enums.SensitiveWordEnum;
import cn.chinotan.service.SensitiveWordInitService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @program: test
 * @description: 测试异常
 * @author: xingcheng
 * @create: 2018-12-08 16:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartOnlyTest.class)
public class SensitiveWordTest {
    
    @Autowired
    SensitiveWordInitService sensitiveWordInitService;
    
    private String words = "啦拉人呢";
    
    private String replaceChar = "*";

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        Set<String> set = sensitiveWordInitService.getSensitiveWord(words, SensitiveWordEnum.MAX_MATCH_TYPE.getType());
        System.out.println("敏感词内容为：" + JSON.toJSONString(set));
        String replaceStr = sensitiveWordInitService.replaceSensitiveWord(words, SensitiveWordEnum.MAX_MATCH_TYPE.getType(),
                replaceChar);
        System.out.println("敏感词内容替换为为：" + replaceStr);
        long end = System.currentTimeMillis();
        System.out.println("查询敏感词耗时：" + (end - start) + " 毫秒");
    }

}
