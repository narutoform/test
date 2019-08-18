package cn.chinotan;

/**
 * @program: test
 * @description: 测试类
 * @author: xingcheng
 * @create: 2018-12-30 20:10
 **/
public class ClientBootstrap {

    public static final String providerName = "UserService#sayHello#";

    public static void main(String[] args) throws InterruptedException {
        RpcConsumer consumer = new RpcConsumer();
        // 创建一个代理对象
        UserService service = (UserService) consumer.createProxy(UserService.class, providerName);
        for (;;) {
            Thread.sleep(1000);
            System.out.println(service.sayHello("are you ok ?"));
        }
    }
    
}
