package cn.chinotan;

import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * @program: test
 * @description: 测试异常
 * @author: xingcheng
 * @create: 2018-12-08 16:11
 **/
public class TryCatchTest {
    
    @Test
    public void tryCatchTest() {
        try {
            exceptionThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void exceptionThrow() {
        try {
            throw new NullPointerException("空指针异常");
        } catch (Exception e) {
            System.out.println("捕获异常2：" + e.getMessage());
            throw new NoSuchElementException("没有这种元素异常");
        }
    }
    
}
