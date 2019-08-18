package cn.chinotan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: redis普通遍历操作
 * @author: xingcheng
 * @create: 2019-03-16 16:47
 **/
@Service("generic")
public class RedisGenericService implements RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;
    
    @Override
    public void batchInsert(List<Map<String, String>> saveList, TimeUnit unit, int timeout) {
        for (Map<String, String> needSave : saveList) {
            redisTemplate.opsForValue().set(needSave.get("key"), needSave.get("value"), timeout,unit);
        }
    }

    @Override
    public List<String> batchGet(List<String> keyList) {
        List<String> values = new ArrayList<>(keyList.size());
        for (String key : keyList) {
            String value = redisTemplate.opsForValue().get(key);
            values.add(value);
        }
        return values;
    }
}
