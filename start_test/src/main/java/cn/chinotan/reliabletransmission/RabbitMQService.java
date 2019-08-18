//package cn.chinotan.service.reliabletransmission;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.UUID;
//
///**
// * @program: test
// * @description: rabbitService
// * @author: xingcheng
// * @create: 2018-09-24 14:28
// **/
//@Service
//public class RabbitMQService {
//
//    Logger logger = LoggerFactory.getLogger(RabbitMQService.class);
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public Boolean send(String exchange, String routingKey, Object message) {
//        try {
//            String key = StringUtils.join(MyConstant.KEY_PREFIX, UUID.randomUUID().toString().replace("-", "").toLowerCase());
//
//            // 发送前保存消息和时间和id到redis缓存中
//            MessageWithTime messageWithTime = new MessageWithTime();
//            messageWithTime.setId(key);
//            messageWithTime.setMessage(JSONObject.toJSONString(message));
//            messageWithTime.setTime(System.currentTimeMillis());
//            redisTemplate.opsForValue().set(key, JSONObject.toJSONString(messageWithTime));
//
//            // 异步回调通知
//            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//                if (ack) {
//                    logger.info("message send success--id:[{}]", correlationData.getId());
//                    // 发送成功后，删除redis缓存
//                    redisTemplate.delete(correlationData.getId());
//                } else {
//                    // 发送失败后打印日志，进行重试
//                    logger.error("message send fail--id:[{}]", correlationData.getId());
//                }
//            });
//
//            CorrelationData correlationData = new CorrelationData(key);
//            rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
//        } catch (Exception e) {
//            logger.error("发送消息异常{}", e);
//            return false;
//        }
//
//        return true;
//    }
//
//    Boolean send(String exchange, String routingKey, MessageWithTime message) {
//        try {
//            // 异步回调通知
//            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//                if (ack) {
//                    logger.info("message send success--id:[{}]", correlationData.getId());
//                    // 发送成功后，删除redis缓存
//                    redisTemplate.delete(correlationData.getId());
//                } else {
//                    // 发送失败后打印日志，进行重试
//                    logger.error("message send fail--id:[{}]", correlationData.getId());
//                }
//            });
//
//            CorrelationData correlationData = new CorrelationData(message.getId());
//            Map map = JSON.parseObject(message.getMessage(), Map.class);
//            rabbitTemplate.convertAndSend(exchange, routingKey, map, correlationData);
//        } catch (Exception e) {
//            logger.error("发送消息异常{}", e);
//            return false;
//        }
//
//        return true;
//    }
//
//}
