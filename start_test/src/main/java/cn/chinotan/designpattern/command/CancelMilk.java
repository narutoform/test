package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 取消牛奶
 * @author: xingcheng
 * @create: 2018-09-02 15:27
 **/
public class CancelMilk implements Command {
    
    private Milk milk;

    public CancelMilk(Milk milk) {
        this.milk = milk;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        milk.cancelMilk();
    }
}
