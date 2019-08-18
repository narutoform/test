package cn.chinotan.service;

/**
 * @program: test
 * @description:
 * @author: xingcheng
 * @create: 2019-02-23 17:52
 **/
public interface Strategy {
    /**
     * 传入一个需要分表的表名，返回一个处理后的表名 
     * Strategy必须包含一个无参构造器
     * @param tableName
     * @return
     */
    String convert(String tableName);
}
