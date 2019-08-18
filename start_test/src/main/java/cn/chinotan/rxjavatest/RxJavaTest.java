package cn.chinotan.rxjavatest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;
import rx.Observable;
import rx.internal.util.InternalObservableUtils;

import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: RxJavaTest
 * @author: xingcheng
 * @create: 2018-11-03 21:39
 **/
public class RxJavaTest {

    public static void main(String[] args) {
        RxJavaTest rxJavaTest = new RxJavaTest();
        try {
            rxJavaTest.timeWindowTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timeWindowTest() throws Exception {
        Observable<Integer> source = Observable.interval(50, TimeUnit.MILLISECONDS).map(i -> RandomUtils.nextInt(0,2));
        source.window(1, TimeUnit.SECONDS).subscribe(window -> {
            int[] metrics = new int[2];
            window.subscribe(i -> metrics[i]++,
                    InternalObservableUtils.ERROR_NOT_IMPLEMENTED,
                    () -> System.out.println("窗口Metrics:" + JSON.toJSONString(metrics)));
        });
        TimeUnit.SECONDS.sleep(10);
    }

}
