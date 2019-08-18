//package cn.chinotan.service.reliabletransmission;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * rabbitMQ配置
// */
//@Configuration
//public class ReliableRabbitConfig {
//
//    @Bean
//    public DirectExchange myExchange() {
//        return new DirectExchange(MyConstant.MY_EXCHANGE, true, false);
//    }
//
//    @Bean
//    public Queue myQueueOne() {
//        return new Queue(MyConstant.MY_QUEUE_THREE, true);
//    }
//
//    @Bean
//    public Binding queueOneBinding() {
//        return BindingBuilder.bind(myQueueOne()).to(myExchange()).withQueueName();
//    }
//}
//
