//package cn.chinotan.service.delayqueuerabbitmq;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessagePostProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @program: test
// * @description: 生产者
// * @author: xingcheng
// * @create: 2018-08-12 12:33
// **/
//@Service
//public class Producr {
//    private static final Logger LOGGER = LoggerFactory.getLogger(Producr.class);
//
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//
//    public void send(String msg, long time, String delayQueueName) {
//        //rabbit默认为毫秒级
//        long times = time * 1000;
//        MessagePostProcessor processor = new MessagePostProcessor() {
//
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setExpiration(String.valueOf(times));
//                return message;
//            }
//        };
//        // 拼装msg
//        msg = StringUtils.join(msg, ":", delayQueueName);
//        amqpTemplate.convertAndSend(MqConstant.MY_EXCHANGE, MqConstant.DEAD_LETTER_QUEUE, msg, processor);
//    }
//}
//
