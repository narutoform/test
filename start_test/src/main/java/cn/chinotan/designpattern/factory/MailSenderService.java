package cn.chinotan.designpattern.factory;

import org.springframework.stereotype.Service;

/**
 * @program: test
 * @description: 发送邮件
 * @author: xingcheng
 * @create: 2019-01-05 19:55
 **/
@Service(Const.MAIL)
public class MailSenderService implements Sender {
    @Override
    public void send() {
        System.out.println("发送邮件");
    }
}
