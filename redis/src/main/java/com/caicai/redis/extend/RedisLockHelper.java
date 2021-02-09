package com.caicai.redis.extend;

import com.caicai.redis.entity.RedisLockEntity;
import com.caicai.redis.exception.LockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLockHelper {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    public void execute(RedisLockEntity entity, RedisLockExtend redisLockExtend) {
        Boolean tryLock = false;
        try {
            tryLock = redisTemplate.opsForValue().setIfAbsent(entity.getLockKey(), "1",
                    entity.getExpire(), entity.getTimeUnit());
            if (tryLock) {
                redisLockExtend.execute();
            }else{
                throw new LockException("获取锁失败了");
            }
        } finally {
            if(tryLock) {
                redisTemplate.delete(entity.getLockKey());
            }
        }

    }

}
