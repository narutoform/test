package cn.chinotan;

import cn.chinotan.designpattern.factory.Const;
import cn.chinotan.designpattern.factory.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @program: test
 * @description: 工厂测试类
 * @author: xingcheng
 * @create: 2019-01-05 20:19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartTest.class)
public class FactoryTest {
    
    @Autowired
    Map<String, Sender> sender;
    
    @Test
    public void factoryTest() {
        Sender sender = this.sender.get(Const.SMS);
        sender.send();
    }
    
}
