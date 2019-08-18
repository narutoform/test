package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 点一份牛奶
 * @author: xingcheng
 * @create: 2018-09-02 15:25
 **/
public class OrderMilk implements Command {
    
    private Milk milk;

    public OrderMilk(Milk milk) {
        this.milk = milk;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        milk.orderMilk();
    }
}
