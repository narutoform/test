package cn.chinotan.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: 订单
 * @author: xingcheng
 * @create: 2018-06-02 15:49
 **/
public class OrderDelay implements Delayed {
    
    private String orderId;
    
    private Long timeout;

    public OrderDelay(String orderId, Long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }

        OrderDelay other = (OrderDelay) o;
        Long d = (getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));

        return d == 0 ? 0 : (d > 0 ? 1 : -1);
    }

    public void print() {
        System.out.println(orderId+"编号的订单要删除啦。。。。");
    }
}
