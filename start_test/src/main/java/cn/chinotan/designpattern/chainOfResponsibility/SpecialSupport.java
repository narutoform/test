package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 只解决某个特定的问题
 * @author: xingcheng
 * @create: 2018-09-16 17:26
 **/
public class SpecialSupport extends Support{
    
    private Integer special;

    public SpecialSupport(Integer special, String name) {
        super(name);
        this.special = special;
    }


    @Override
    protected Boolean resolve(Problem problem) {
        if (problem.getCount().equals(special)){
            return true;
        } else {
            return false;
        }
    }
}
