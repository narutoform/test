package cn.chinotan.thredLocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: test
 * @description: thredLocalDemo
 * @author: xingcheng
 * @create: 2018-09-09 17:13
 **/
public class ThreadLocalDemo {

    static ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        // 进行初始化
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static Integer countRef = 0;

    private Integer getNextCount() {
        count.set(count.get() + 1);
        return count.get();
    }

    private Integer getNextCountRef() {
        countRef = countRef + 1;
        return countRef;
    }
    
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        executorService.execute(new CountRun(threadLocalDemo));
        executorService.execute(new CountRun(threadLocalDemo));
        executorService.execute(new CountRun(threadLocalDemo));
        
        // 参照
        ThreadLocalDemo threadLocalDemoRef = new ThreadLocalDemo();
        executorService.execute(new CountRunRef(threadLocalDemoRef));
        executorService.execute(new CountRunRef(threadLocalDemoRef));
        executorService.execute(new CountRunRef(threadLocalDemoRef));

        executorService.shutdown();
    }
    
    static class CountRun implements Runnable{

        private ThreadLocalDemo demo;

        public CountRun(ThreadLocalDemo dem) {
            demo = dem;
        }

        @Override
        public void run() {
            for(int i = 0; i < 3; i++){
                System.out.println("thread[" + Thread.currentThread().getName()+ "] count [" + demo.getNextCount() + "]");
            }
        }
    }

    static class CountRunRef extends Thread{

        private ThreadLocalDemo demo;

        public CountRunRef(ThreadLocalDemo dem) {
            demo = dem;
        }

        @Override
        public void run() {
            for(int i = 0; i < 3; i++){
                System.out.println("threadRef[" + Thread.currentThread().getName()+ "] count [" + demo.getNextCountRef() + "]");
            }
        }
    }
}
