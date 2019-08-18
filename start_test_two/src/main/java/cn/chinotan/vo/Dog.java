package cn.chinotan.vo;

import cn.chinotan.advice.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @program: test
 * @description: 狗
 * @author: xingcheng
 * @create: 2018-10-27 16:00
 **/
@Service
public class Dog implements Animal {
    
    @Autowired
    ApplicationContext applicationContext;

    @Action
    @Override
    public String run(String where) {
        System.out.println("狗往" + where + "跑");
        return "地点是：" + where;
    }

    @Override
    public void runToEat(String food) {
//        Dog dog = (Dog) AopContext.currentProxy();
        Dog dog = (Dog) applicationContext.getBean("dog");
        dog.run("狗窝");
        System.out.println("狗在吃" + food);
    }
}
