package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 发送信息类工厂
 * @author: xingcheng
 * @create: 2019-01-05 19:56
 **/
public class SendFactory {

    /**
     * 简单工厂
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if (Const.MAIL.equals(type)) {
            return new MailSender();
        } else if (Const.SMS.equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    /**
     * 多个方法
     * @return
     */
    public Sender produceMail() {
        return new MailSender();
    }

    /**
     * 多个方法
     * @return
     */
    public Sender produceSms(){
        return new SmsSender();
    }

    /**
     * 静态工厂
     * @return
     */
    public static Sender staticProduceMail(){
        return new MailSender();
    }

    /**
     * 静态工厂
     * @return
     */
    public static Sender staticProduceSms(){
        return new SmsSender();
    }
}
