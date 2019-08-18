//package cn.chinotan.service.reliabletransmission;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//
///**
// * queueThree消费者
// */
//@Component
//public class MyQueueThreeConsumer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyQueueThreeConsumer.class);
//
//    /**
//     * 消费者做好幂等
//     *
//     * @param content
//     */
//    @RabbitListener(queues = MyConstant.MY_QUEUE_THREE)
//    @RabbitHandler
//    public void process(Map content) {
//        LOGGER.info("消费者，queueThree开始执行 {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        LOGGER.info("消费者，queueThree消费内容：[{}]", JSON.toJSONString(content));
//    }
//}
