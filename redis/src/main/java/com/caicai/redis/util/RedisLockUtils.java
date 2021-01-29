package com.caicai.redis.util;

import com.caicai.redis.extend.RedisLockExtend;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RedisLockUtils
 * @Package: com.caicai.redis.util
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/29 9:38
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Slf4j
public class RedisLockUtils {

    private String lockKey;
    private Long expire;
    private TimeUnit timeUnit;
    private  RedisLockExtend redisLockExtend;

    public RedisLockUtils(String lockKey, Long expire, TimeUnit timeUnit, RedisLockExtend redisLockExtend) {
        this.lockKey = lockKey;
        this.expire = expire;
        this.timeUnit = timeUnit;
        this.redisLockExtend = redisLockExtend;
    }

    public RedisLockUtils(String lockKey, Long expire, RedisLockExtend redisLockExtend) {
        this(lockKey, expire, TimeUnit.SECONDS, redisLockExtend);
    }

    public void execute() {
        Boolean isLock = false;
        try {
            //redis分布式锁
            isLock = true;
            redisLockExtend.execute();
        } catch (Exception e) {
            log.error("抛出异常线程:{} , 异常信息:{}", Thread.currentThread().getName(), e.getMessage());
        }finally {
            log.info("当前线程:{} , 当前isLock值: {} ", Thread.currentThread().getName(), isLock);
            if (isLock) {
                //释放锁
            }
        }
    }
}
