//package cn.chinotan.service.delayqueuerabbitmq;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @program: test
// * @description: queueTwo队列
// * @author: xingcheng
// * @create: 2018-08-12 12:35
// **/
//@Service
//public class MyQueueTwoConsumer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyQueueTwoConsumer.class);
//    @Autowired
//    private Producr producr;
//
//    @RabbitListener(queues=MqConstant.MY_QUEUE_TWO)
//    @RabbitHandler
//    public void process(String content) {
//        LOGGER.info("延迟时间到，queueTwo开始执行 {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    }
//}
