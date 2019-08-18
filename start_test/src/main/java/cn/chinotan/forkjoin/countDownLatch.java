package cn.chinotan.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: test
 * @description: 多任务并行计算
 * @author: xingcheng
 * @create: 2018-08-26 18:08
 **/
public class countDownLatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(countDownLatch.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Long> submitOne = executorService.submit(new ArrayOneSum());
        Future<Long> submitTwo = executorService.submit(new ArrayTwoSum());
//        countDownLatch.await();

        long arrayTwoSum = submitTwo.get();
        long arrayOneSum = submitOne.get();
        
        LOGGER.info("最后结果为：{}", arrayOneSum + arrayTwoSum);
    }
    
    static class ArrayOneSum implements Callable<Long> {

        private CountDownLatch countDown;

//        public ArrayOneSum(CountDownLatch countDown) {
//            this.countDown = countDown;
//        }

        @Override
        public Long call() throws Exception {
            int sum = 0;
            long[] arrays = new long[1000000];
            for(int i = 0; i < arrays.length; i++) {
                arrays[i] = new Random().nextLong();
            }
            Long forkJoinSum = ForkJoinDemo.getForkJoinSum(arrays);
//            countDown.countDown();

            return 2L;
        }
    }

    static class ArrayTwoSum implements Callable<Long> {

        private CountDownLatch countDown;

//        public ArrayTwoSum(CountDownLatch countDown) {
//            this.countDown = countDown;
//        }
        
        @Override
        public Long call() throws Exception {
            int sum = 0;
            long[] arrays = new long[10000];
            for(int i = 0; i < arrays.length; i++) {
                arrays[i] = new Random().nextLong();
            }
            Long forkJoinSum = ForkJoinDemo.getForkJoinSum(arrays);
            Thread.sleep(2000);
//            countDown.countDown();

            return 1L;
        }
    }
}
