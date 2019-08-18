package cn.chinotan.designpattern.chainOfResponsibility;

/**
 * @program: test
 * @description: 测试启动类
 * @author: xingcheng
 * @create: 2018-09-16 17:28
 **/
public class DemoTest {

    public static void main(String[] args) {
        NotSupport noSupport = new NotSupport("noSupport");
        LimitSupport limitSupport100 = new LimitSupport(100, "limitSupport100");
        LimitSupport limitSupport200 = new LimitSupport(200, "limitSupport200");
        LimitSupport limitSupport300 = new LimitSupport(300, "limitSupport300");
        EvenSupport evenSupport = new EvenSupport("evenSupport");
        SpecialSupport specialSupport = new SpecialSupport(363, "specialSupport");
        
        noSupport.setNext(limitSupport100).setNext(limitSupport200).setNext(limitSupport300).setNext(evenSupport).setNext(specialSupport);
        
        for (int i = 0; i < 500; i+= 33){
            noSupport.support(new Problem(i));
        }
    }
    
}
