package cn.chinotan.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: 测试延时队列
 * @author: xingcheng
 * @create: 2018-06-02 16:35
 **/
public class DelayQueueDemo {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("000001");
        list.add("000002");
        list.add("000003");
        list.add("000004");
        list.add("000005");
        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        Long start = System.currentTimeMillis();
        list.stream().forEach(orderId -> {
            queue.put(new OrderDelay(orderId, TimeUnit.NANOSECONDS.convert(2, TimeUnit.SECONDS)));
            try {
                queue.take().print();
                System.out.println("after" + (System.currentTimeMillis() - start) + "millis");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
}
