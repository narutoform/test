import cn.chinotan.service.reliabletransmission.MyConstant;
import cn.chinotan.service.reliabletransmission.RabbitMQService;
import cn.chinotan.service.reliabletransmission.ReliableProducr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: 可靠投递测试
 * @author: xingcheng
 * @create: 2018-09-24 15:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class ReliableTransmissionTest {

    @Autowired
    private ReliableProducr producr;

    @Autowired
    private RabbitMQService rabbitMQService;

    /**
     * 正常情况测试
     * @throws Exception
     */
    @Test
    public void reliableTransmissionTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", "xingheng");
        producr.send(map);
    }

    /**
     * 异常情况测试
     * @throws Exception
     */
    @Test
    public void reliableTransmissionFailTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", "xingheng");
        rabbitMQService.send(MyConstant.ERROR_EXCHANGE, MyConstant.MY_QUEUE_THREE, map);
    }
}
