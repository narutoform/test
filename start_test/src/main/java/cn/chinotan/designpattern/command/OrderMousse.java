package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 点一份甜点
 * @author: xingcheng
 * @create: 2018-09-02 15:31
 **/
public class OrderMousse implements Command {
    
    private Mousse mousse;

    public OrderMousse(Mousse mousse) {
        this.mousse = mousse;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        mousse.orderMousse();
    }
}
