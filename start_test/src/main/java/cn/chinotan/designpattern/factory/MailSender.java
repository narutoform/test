package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 发送邮件
 * @author: xingcheng
 * @create: 2019-01-05 19:55
 **/
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送邮件");
    }
}
