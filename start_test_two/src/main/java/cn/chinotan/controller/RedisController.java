package cn.chinotan.controller;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCommands;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @program: test
 * @description: redis测试
 * @author: xingcheng
 * @create: 2019-03-09 16:26
 **/
@RestController
@RequestMapping("/redis")
@Log
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    public static final String KEY = "chinotan:redis:pass";

    public static final String NX_KEY = "chinotan:redis:nx";

    public static final String VALUE = "redis-pass-value";

    /**
     * 间隔时间 3秒
     */
    public static final Long NX_SLEEP_TIME = 50L;

    /**
     * 模拟耗时操作 3秒
     */
    public static final Long TIME_CONSUMING = 1 * 1000L;

    /**
     * VALUE缓存时间 5秒
     */
    public static final Long VALUE_TIME = 5 * 1000L;

    /**
     * 锁缓存时间 5分钟
     */
    public static final Long NX_TIME = 5 * 60L;

    @GetMapping(value = "/pass")
    public Object hello() throws Exception {
        long cacheStart = System.currentTimeMillis();
        String value = redisTemplate.opsForValue().get(KEY);
        long cacheEnd = System.currentTimeMillis();
        if (StringUtils.isBlank(value)) {
            long start = System.currentTimeMillis();
            if (setNX(NX_KEY, NX_KEY)) {
                // 模拟耗时操作，从数据库获取
                TimeUnit.MILLISECONDS.sleep(TIME_CONSUMING);
                redisTemplate.opsForValue().set(KEY, VALUE, VALUE_TIME, TimeUnit.MILLISECONDS);
                long end = System.currentTimeMillis();
                redisTemplate.delete(NX_KEY);
                log.info("从数据库中获取耗时: " + (end - start) + "ms");
                return VALUE;
            } else {
                TimeUnit.MILLISECONDS.sleep(NX_SLEEP_TIME);
                log.info("缓存穿透递归");
                return hello();
            }

        } else {
            log.info("从缓存中获取耗时：" + (cacheEnd - cacheStart) + "ms");
            return value;
        }
    }

    private boolean setNX(String key, String value) {
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(key, value);
        redisTemplate.expire(key, NX_TIME, TimeUnit.SECONDS);
        return aBoolean;
    }

}
