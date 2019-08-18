package cn.chinotan.controller;

import cn.chinotan.service.RedisService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: redis批量数据测试
 * @author: xingcheng
 * @create: 2019-03-16 16:26
 **/
@RestController
@RequestMapping("/redisBatch")
@Log
public class RedisBatchController {

    @Autowired
    StringRedisTemplate redisTemplate;
    
    @Autowired
    Map<String, RedisService> redisServiceMap;

    /**
     * VALUE缓存时间 3分钟
     */
    public static final Integer VALUE_TIME = 1;

    /**
     * 测试列表长度
     */
    public static final Integer SIZE = 100000;

    @GetMapping(value = "/test/{model}")
    public Object hello(@PathVariable("model") String model) {
        List<Map<String, String>> saveList = new ArrayList<>(SIZE);
        List<String> keyList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            Map<String, String> objectObjectMap = new HashMap<>();
            String key = String.valueOf(i);
            objectObjectMap.put("key", key);
            StringBuilder sb = new StringBuilder();
            objectObjectMap.put("value", sb.append("value").append(i).toString());
            saveList.add(objectObjectMap);
            // 记录全部key
            keyList.add(key);
        }
        
        // 获取对应的实现
        RedisService redisService = redisServiceMap.get(model);
        
        long saveStart = System.currentTimeMillis();
        redisService.batchInsert(saveList, TimeUnit.MINUTES, VALUE_TIME);
        long saveEnd = System.currentTimeMillis();
        log.info("插入耗时：" + (saveEnd - saveStart) + " ms");
        // 批量获取
        long getStart = System.currentTimeMillis();
        List<String> valueList = redisService.batchGet(keyList);
        long getEnd = System.currentTimeMillis();
        log.info("获取耗时：" + (getEnd - getStart) + " ms");
        return valueList;
    }
}
