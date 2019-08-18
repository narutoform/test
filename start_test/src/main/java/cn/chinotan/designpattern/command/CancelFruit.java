package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 取消水果
 * @author: xingcheng
 * @create: 2018-09-02 15:30
 **/
public class CancelFruit implements Command {
    
    private Fruit fruit;

    public CancelFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        fruit.cancelFruit();
    }
}
