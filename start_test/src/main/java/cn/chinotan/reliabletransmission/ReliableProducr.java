//package cn.chinotan.service.reliabletransmission;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
///**
// * 生产者
// */
//@Service
//public class ReliableProducr {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ReliableProducr.class);
//
//    @Autowired
//    private RabbitMQService rabbitMQService;
//
//    public Boolean send(Map msg) {
//        return rabbitMQService.send(MyConstant.MY_EXCHANGE, MyConstant.MY_QUEUE_THREE, msg);
//    }
//
//    public Boolean send(MessageWithTime msg) {
//        return rabbitMQService.send(MyConstant.MY_EXCHANGE, MyConstant.MY_QUEUE_THREE, msg);
//    }
//}
//
