package cn.chinotan.reliabletransmission;

/**
 * @program: test
 * @description: rabbitMq常量
 * @author: xingcheng
 * @create: 2018-08-12 12:30
 **/
public class MyConstant {

    public static final String MY_EXCHANGE = "my_exchange";
    
    public static final String ERROR_EXCHANGE = "error_exchange";

    public static final String MY_QUEUE_THREE = "my_queue_three";

    public final static String KEY_PREFIX = "test:rabbitMq:";

    /**
     * consumer失败后等待时间(mils)
     */
    public static final int ONE_MINUTE = 1 * 60 * 1000;

    /**
     * MQ消息retry时间
     */
    public static final int RETRY_TIME_INTERVAL = ONE_MINUTE;

    /**
     * MQ消息有效时间
     */
    public static final int VALID_TIME = ONE_MINUTE;

}
