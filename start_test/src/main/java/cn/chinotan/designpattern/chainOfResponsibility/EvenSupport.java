package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 只解决部分问题的节点
 * @author: xingcheng
 * @create: 2018-09-16 17:02
 **/
public class EvenSupport extends Support {

    public EvenSupport(String name) {
        super(name);
    }

    @Override
    protected Boolean resolve(Problem problem) {
        if ((problem.getCount() & 1) == 0){
            return true;
        } else {
            return false;
        }
    }
}
