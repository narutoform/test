package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 甜点
 * @author: xingcheng
 * @create: 2018-09-02 15:17
 **/
public class Mousse {

    /**
     * 点一份甜点
     */
    void orderMousse(){
        System.out.println("来一份甜点");
    }

    /**
     * 取消甜点
     */
    void cancelMousse(){
        System.out.println("取消甜点");
    }
}
