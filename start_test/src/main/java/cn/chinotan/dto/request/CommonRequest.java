package cn.chinotan.dto.request;

import java.io.Serializable;

/**
 * @program: test
 * @description: 公共请求
 * @author: xingcheng
 * @create: 2019-03-02 17:18
 **/
public class CommonRequest implements Serializable {

    private static final long serialVersionUID = -2617189175983301155L;

    public static ThreadLocal<Boolean> isTest = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };

    public static Boolean isTest() {
        return CommonRequest.isTest.get();
    }

    public static void setTest(Boolean test) {
        CommonRequest.isTest.set(test);
    }
}
