package cn.chinotan.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @program: test
 * @description: 单任务并行计算
 * @author: xingcheng
 * @create: 2018-08-26 16:16
 **/
public class ForkJoinDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(ForkJoinDemo.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long[] arrays = new long[1000000];
        for(int i = 0; i < arrays.length; i++) {
            arrays[i] = new Random().nextLong();
        }
        getForkJoinSum(arrays);
    }
    
    public static Long getForkJoinSum(long[] arrays) throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        MyTask myTask = new MyTask(arrays, 0, arrays.length - 1);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(myTask);
        Long result = myTask.get();
        long end = System.currentTimeMillis();
        LOGGER.info("结果为：{}", result);
        LOGGER.warn("耗时：{} 毫秒", end - begin);
        
        return result;
    }
}

class MyTask extends RecursiveTask<Long> {

    /**
     * 阈值，超过这个数量则采用并行计算
     */
    private final long THRESHOLD = 999996;
    
    private long[] arrays;

    private int low;
    
    private int high;
    
    @Override
    protected Long compute() {
        /**
         * 总数
         */
        long sum = 0;
        
        if (high - low <= THRESHOLD) {
            for(int i = low; i <= high; i++) {
                sum += arrays[i];  
            }
        } else {
            /**
             * 无符号右移1位，忽略符号位，空位都以0补齐，右移n位相当于除以2的n次方
             */
            int mid = (low + high) >>> 1;

            /**
             * 将一个大任务分成两个小任务
             */
            MyTask left = new MyTask(arrays, low, mid);
            MyTask right = new MyTask(arrays, mid + 1, high);

            /**
             * 分别计算
             */
            left.fork();
            right.fork();
            
            sum = left.join() + right.join();
        }
        
        return sum;
    }
    
    public MyTask(long[] arrays, int low, int high) {
        this.arrays = arrays;
        this.low = low;
        this.high = high;
    }
}