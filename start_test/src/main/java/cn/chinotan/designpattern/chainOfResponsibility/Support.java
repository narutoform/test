package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 当前节点可以解决就解决，否则交给下一个节点
 * @author: xingcheng
 * @create: 2018-09-16 16:41
 **/
public abstract class Support {

    /**
     * 处理节点名称
     */
    private String name;

    /**
     * 下一个处理节点
     */
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public final void support(Problem problem){
        if (resolve(problem)){
            success(problem);
        } else if (next != null){
            next.support(problem);
        } else {
            fail(problem);
        }
    }

    /**
     * 进行解决
     * @param problem 待解决的问题
     * @return
     */
    protected abstract Boolean resolve(Problem problem);

    /**
     * 解决失败
     * @param problem 待解决的问题
     */
    protected void fail(Problem problem){
        System.out.println(problem + "无法解决");
    }

    /**
     * 成功解决
     * @param problem 待解决的问题
     */
    protected void success(Problem problem){
        System.out.println(problem + "解决成功} by " + this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[name='").append(name).append("]");
        return sb.toString();
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }
}
