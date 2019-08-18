//package cn.chinotan.service.reliabletransmission;
//
//import com.alibaba.fastjson.JSON;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
///**
// * @program: test
// * @description: 缓存重试
// * @author: xingcheng
// * @create: 2018-09-24 16:12
// **/
//@Component("retryCache")
//public class RetryCache {
//
//    private boolean stop = false;
//
//    Logger logger = LoggerFactory.getLogger(RetryCache.class);
//
//    @Autowired
//    private ReliableProducr producr;
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//    
//    private final String STAR = "*";
//
//    public void startRetry() {
//        while (!stop) {
//            try {
//                Thread.sleep(MyConstant.RETRY_TIME_INTERVAL);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            long now = System.currentTimeMillis();
//
//            Set<String> keys = redisTemplate.keys(StringUtils.join(MyConstant.KEY_PREFIX, STAR));
//            if (keys != null && !keys.isEmpty()) {
//                List<String> list = redisTemplate.opsForValue().multiGet(keys);
//                list.forEach(value -> {
//                    MessageWithTime messageWithTime = JSON.parseObject(value, MessageWithTime.class);
//
//                    if (null != messageWithTime) {
//                        if (messageWithTime.getTime() + 3 * MyConstant.VALID_TIME < now) {
//                            logger.error("send message {} failed after 3 min ", messageWithTime);
//                            redisTemplate.delete(messageWithTime.getId());
//                        } else if (messageWithTime.getTime() + MyConstant.VALID_TIME < now) {
//                            Boolean send = producr.send(messageWithTime);
//                            logger.info("进行重新投递消息");
//                            if (!send) {
//                                logger.error("retry send message failed {}", messageWithTime);
//                            }
//                        }
//                    }
//                });
//            }
//        }
//    }
//
//}
