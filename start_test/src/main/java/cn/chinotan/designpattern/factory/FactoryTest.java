package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 工厂测试类
 * @author: xingcheng
 * @create: 2019-01-05 19:58
 **/
public class FactoryTest {
    public static void main(String[] args) {
        /**
         * 普通
         */
        SendFactory factory = new SendFactory();
        Sender senderOne = factory.produce(Const.MAIL);
        senderOne.send();

        /**
         * 多个方法
         */
        Sender senderTwo = factory.produceSms();
        senderTwo.send();

        /**
         * 静态工厂
         */
        SendFactory.staticProduceMail().send();

        /**
         * 工厂方法模式
         */
        Provider provider = new SendSmsFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
