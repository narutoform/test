package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 待解决的问题
 * @author: xingcheng
 * @create: 2018-09-16 16:47
 **/
public class Problem {
    
    private Integer count;

    public Problem(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Problem{");
        sb.append("问题：").append(count);
        return sb.toString();
    }
}
