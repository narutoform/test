package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 发送短信
 * @author: xingcheng
 * @create: 2019-01-05 19:55
 **/
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
