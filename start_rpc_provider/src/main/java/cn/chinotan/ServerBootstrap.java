package cn.chinotan;

/**
 * @program: test
 * @description: 启动类
 * @author: xingcheng
 * @create: 2018-12-30 19:52
 **/
public class ServerBootstrap {

    public static void main(String[] args) {
        UserServiceImpl.startServer("localhost", 8990);
    }

}
