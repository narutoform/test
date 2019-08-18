package cn.chinotan.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: test
 * @description: 路由策略
 * @author: xingcheng
 * @create: 2019-02-23 16:44
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TableConfig {
    //是否影子表
    boolean isTest() default true;

    //表名
    String value() default "";

    //获取分表策略
    String strategy();
}
