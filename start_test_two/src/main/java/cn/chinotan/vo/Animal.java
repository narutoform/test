package cn.chinotan.vo;

/**
 * @program: test
 * @description: 动物
 * @author: xingcheng
 **/
public interface Animal {

    /**
     * 跑
     * @param where 在什么地方跑
     * @return
     */
    String run (String where);

    /**
     * 跑去吃食物
     * @param food
     */
    void runToEat(String food);
    
}
