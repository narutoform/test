package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 水果
 * @author: xingcheng
 * @create: 2018-09-02 15:18
 **/
public class Fruit {

    /**
     * 点一份水果
     */
    void orderFruit(){
        System.out.println("来一份水果");
    }

    /**
     * 取消水果
     */
    void cancelFruit(){
        System.out.println("取消水果");
    }
}
