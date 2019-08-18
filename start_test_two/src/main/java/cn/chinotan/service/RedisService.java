package cn.chinotan.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: redis测试
 * @author: xingcheng
 * @create: 2019-03-16 16:45
 **/
public interface RedisService {

    /**
     * 批量插入
     * @param saveList
     * @param unit
     * @param timeout
     */
    void batchInsert(List<Map<String, String>> saveList, TimeUnit unit, int timeout);

    /**
     * 批量获取
     * @param keyList
     * @return
     */
    List<String> batchGet(List<String> keyList);
}
