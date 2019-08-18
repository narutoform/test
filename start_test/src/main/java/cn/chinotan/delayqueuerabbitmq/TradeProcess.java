//package cn.chinotan.service.delayqueuerabbitmq;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.AmqpTemplate;
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
// * @description: 转发队列
// * @author: xingcheng
// * @create: 2018-08-12 12:35
// **/
//@Service
//public class TradeProcess {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TradeProcess.class);
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//    
//    @RabbitListener(queues=MqConstant.MY_TRANS_QUEUE)
//    @RabbitHandler
//    public void process(String content) {
//        String msg = content.split(":")[0];
//        String delayQueueName = content.split(":")[1];
//        amqpTemplate.convertAndSend(MqConstant.MY_EXCHANGE, delayQueueName, msg);
//        LOGGER.info("进行转发 {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    }
//}
