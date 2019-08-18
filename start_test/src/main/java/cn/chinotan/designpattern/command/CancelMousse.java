package cn.chinotan.designpattern.command;

/**
 * @program: test
 * @description: 取消甜点
 * @author: xingcheng
 * @create: 2018-09-02 15:32
 **/
public class CancelMousse implements Command {
    
    private Mousse mousse;

    public CancelMousse(Mousse mousse) {
        this.mousse = mousse;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        mousse.cancelMousse();
    }
}
