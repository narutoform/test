package cn.chinotan.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: test
 * @description: 动作aop实现
 * @author: xingcheng
 **/
@Aspect
@Component
public class ActionAspect {

    @Pointcut("@annotation(cn.chinotan.advice.Action)")
    void actionPointCut() {
    }

    @Before("actionPointCut()")
    void beforeAction() {
        System.out.println("热身运动");
    }
}
