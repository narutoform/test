package cn.chinotan;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * @program: test
 * @description: 多线程测试
 * @author: xingcheng
 * @create: 2019-03-23 17:27
 **/
@Slf4j
public class ExecutorTest {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(15);

        CompletableFuture[] completableFutures = new CompletableFuture[15];
        List<Integer> integers = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> costMethod(finalI), executorService)
                    .whenComplete((r, e) -> {
                        if (null != e) {
                           e.printStackTrace(); 
                        } else {
                            integers.add(r);
                        }
                    });

            completableFutures[i] = integerCompletableFuture;
        }

        CompletableFuture.allOf(completableFutures).join();
        long count = integers.stream().count();
        log.info("一共处理成功：{}", count);
    }

    /**
     * 耗时的操作
     *
     * @param i
     * @return
     */
    public int costMethod(int i) {
        try {
            TimeUnit.SECONDS.sleep(5);
            log.info("耗时的操作 {}", i);
            return 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
