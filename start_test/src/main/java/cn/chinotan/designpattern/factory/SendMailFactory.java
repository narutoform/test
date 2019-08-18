package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 发送邮件工厂方法
 * @author: xingcheng
 * @create: 2019-01-05 20:07
 **/
public class SendMailFactory implements Provider  {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
