package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 牛奶
 * @author: xingcheng
 * @create: 2018-09-02 15:22
 **/
public class Milk {

    /**
     * 点一份牛奶
     */
    void orderMilk(){
        System.out.println("来一份牛奶");
    }
    
    /**
     * 取消牛奶
     */
    void cancelMilk(){
        System.out.println("取消牛奶");
    }
}
