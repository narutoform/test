package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 发送短信工厂方法
 * @author: xingcheng
 * @create: 2019-01-05 20:08
 **/
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
