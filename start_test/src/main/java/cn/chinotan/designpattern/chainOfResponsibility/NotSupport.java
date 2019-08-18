package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 永远不解决问题的节点
 * @author: xingcheng
 * @create: 2018-09-16 17:02
 **/
public class NotSupport extends Support{

    public NotSupport(String name) {
        super(name);
    }

    @Override
    protected Boolean resolve(Problem problem) {
        return false;
    }
}
