package com.caicai.redis.entity;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class RedisLockEntity {

    private String lockKey;
    private Long expire;
    private TimeUnit timeUnit;

    public RedisLockEntity(String lockKey) {
        this(lockKey, 60L, TimeUnit.SECONDS);
    }

    public RedisLockEntity(String lockKey, Long expire, TimeUnit timeUnit) {
        this.lockKey = lockKey;
        this.expire = expire;
        this.timeUnit = timeUnit;
    }

}
