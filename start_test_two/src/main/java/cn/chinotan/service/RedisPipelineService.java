package cn.chinotan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @program: test
 * @description: redis管道操作
 * @author: xingcheng
 * @create: 2019-03-16 16:47
 **/
@Service("pipe")
public class RedisPipelineService implements RedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void batchInsert(List<Map<String, String>> saveList, TimeUnit unit, int timeout) {
        /* 插入多条数据 */
        redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                for (Map<String, String> needSave : saveList) {
                    redisTemplate.opsForValue().set(needSave.get("key"), needSave.get("value"), timeout,unit);
                }
                return null;
            }
        });
    }

    @Override
    public List<String> batchGet(List<String> keyList) {
        /* 批量获取多条数据 */
        List<Object> objects = redisTemplate.executePipelined(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) redisConnection;
                for (String key : keyList) {
                    stringRedisConnection.get(key);
                }
                return null;
            }
        });

        List<String> collect = objects.stream().map(val -> String.valueOf(val)).collect(Collectors.toList());

        return collect;
    }
}
