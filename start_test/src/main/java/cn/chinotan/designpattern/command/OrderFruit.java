package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 点一份水果
 * @author: xingcheng
 * @create: 2018-09-02 15:29
 **/
public class OrderFruit implements Command {
    
    private Fruit fruit;

    public OrderFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        fruit.orderFruit();
    }
}
