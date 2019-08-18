package cn.chinotan.designpattern.factory;

/**
 * @program: test
 * @description: 工厂方法模式工厂接口
 * @author: xingcheng
 * @create: 2019-01-05 20:06
 **/
public interface Provider {
    /**
     * 工厂生产接口
     * @return
     */
    Sender produce();
}
