package cn.chinotan.designpattern.factory;

import org.springframework.stereotype.Service;

/**
 * @program: test
 * @description: 发送短信
 * @author: xingcheng
 * @create: 2019-01-05 19:55
 **/
@Service(Const.SMS)
public class SmsSenderService implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
