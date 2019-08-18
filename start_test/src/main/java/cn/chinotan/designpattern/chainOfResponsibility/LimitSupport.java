package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 解决部分范围的问题
 * @author: xingcheng
 * @create: 2018-09-16 17:15
 **/
public class LimitSupport extends Support {
    
    private Integer limit;
    
    public LimitSupport(Integer limit, String name) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected Boolean resolve(Problem problem) {
        if (problem.getCount() < limit){
            return true;
        } else {
            return false;
        }
    }
}
