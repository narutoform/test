//package cn.chinotan.controller;
//
//import cn.chinotan.service.delayqueuerabbitmq.MqConstant;
//import cn.chinotan.service.delayqueuerabbitmq.Producr;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @program: test
// * @description: 延时队列启动类
// * @author: xingcheng
// * @create: 2018-08-12 15:41
// **/
//@RestController
//@RequestMapping("/delayQueue")
//public class DelayQueueController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DelayQueueController.class);
//
//    @Autowired
//    private Producr producr;
//
//    @GetMapping("/send/{time}")
//    public String send(@PathVariable("time") int time){
//        LOGGER.info("{}秒后, 发送延迟消息，当前时间{}", time, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        producr.send("我是延时消息...", time, MqConstant.MY_QUEUE_ONE);
//        return "ok";
//    }
//    
//}
