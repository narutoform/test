//package cn.chinotan.service.delayqueuerabbitmq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @program: test
// * @description: 延时队列rabbitMQ配置
// * @author: xingcheng
// * @create: 2018-08-12 12:27
// **/
////@Configuration
//public class RabbitConfig {
//
//    @Bean
//    public DirectExchange myExchange() {
//        return new DirectExchange(MqConstant.MY_EXCHANGE, true, false);
//    }
//
//    @Bean
//    public Queue myQueueOne() {
//        return new Queue(MqConstant.MY_QUEUE_ONE, true, false, false);
//    }
//
//    @Bean
//    public Queue myQueueTwo() {
//        return new Queue(MqConstant.MY_QUEUE_TWO, true, false, false);
//    }
//    @Bean
//    public Queue myTransQueue() {
//        return new Queue(MqConstant.MY_TRANS_QUEUE, true, false, false);
//    }
//
//    @Bean
//    public Queue deadLetterQueue() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("x-dead-letter-exchange", MqConstant.MY_EXCHANGE);
//        map.put("x-dead-letter-routing-key", MqConstant.MY_TRANS_QUEUE);
//        Queue queue = new Queue(MqConstant.DEAD_LETTER_QUEUE, true, false, false, map);
//        System.out.println("arguments :" + queue.getArguments());
//        return queue;
//    }
//
//    @Bean
//    public Binding queueOneBinding() {
//        return BindingBuilder.bind(myQueueOne()).to(myExchange()).with(MqConstant.MY_QUEUE_ONE);
//    }
//
//    @Bean
//    public Binding queueTwoBinding() {
//        return BindingBuilder.bind(myQueueTwo()).to(myExchange()).with(MqConstant.MY_QUEUE_TWO);
//    }
//
//    @Bean
//    public Binding queueDeadBinding() {
//        return BindingBuilder.bind(deadLetterQueue()).to(myExchange()).with(MqConstant.DEAD_LETTER_QUEUE);
//    }
//
//    @Bean
//    public Binding queueTransBinding() {
//        return BindingBuilder.bind(myTransQueue()).to(myExchange()).with(MqConstant.MY_TRANS_QUEUE);
//    }
//}
//
